package edu.carleton.comp4601.migration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.carleton.comp4601.model.Review;
import edu.carleton.comp4601.utils.Constants;
import edu.carleton.comp4601.utils.CSV;
import edu.carleton.comp4601.utils.Category;

/**
 * @author Hector Zhang & Rui Li
 */
public class ReviewMigration {

	/**
	 * Transforms an HTML document to a review by extracting information from
	 * the HTML.
	 * @param reviewDoc the HTML document
	 * @return Review POJO
	 */
	private static Review transformDocToReview(Document reviewDoc) {
		String movieName = reviewDoc.title();
		Elements metadata = reviewDoc.select("meta");
		String summaryBody = reviewDoc.body().text();
		String userNameRaw = null;
		String scoreRaw = null;
		String helpfulnessRaw = null;
		for (Element meta : metadata) {
			String metaName = meta.attr("name");
			String metaValue = meta.attr("content");
			if (metaName.equals("userId"))
				userNameRaw = metaValue;
			else if (metaName.equals("score"))
				scoreRaw = metaValue;
			else if (metaName.equals("helpfulness")) 
				helpfulnessRaw = metaValue;
		}
		Double rating = Double.valueOf(helpfulnessRaw.split("/")[0]);
		Double overall = Double.valueOf(helpfulnessRaw.split("/")[1]);
		Double helpfulness = (overall != 0 ? (rating / overall) * 10 : 0d);
		String genre = (Category.isComedy(summaryBody) ? "comedy" : "other");
		genre = (Category.isDrama(summaryBody) ? "drama" : genre);
		genre = (Category.isFamily(summaryBody) ? "family" : genre);
		genre = (Category.isHorror(summaryBody) ? "horror" : genre);
		Review review = new Review();
		review.setUserName(userNameRaw);
		review.setMovieName(movieName);
		review.setScore(Double.valueOf(scoreRaw) * 2);
		review.setHelpfulness(helpfulness);
		review.setGenre(genre);
		return review;
	}

	public static List<Review> extractReviews() {
		List<Review> reviews = new ArrayList<Review>();
		File folder = new File(Constants.RAW_DATA_PATH_REVIEWS);
		System.out.println("Path of Reviews: " + Constants.RAW_DATA_PATH_REVIEWS);
		System.out.println("Number of Files: " + folder.listFiles().length);
		System.out.println("Number of Reviews: " + reviews.size());
		System.out.println("Creating Reviews...");
		System.out.println("Please be patient...");
		System.out.println();
		Constants.updateTotalItemsReviews(reviews.size());
		Constants.updateTotalItemToMigrate();
		int id = 0;
		for (File file : folder.listFiles()){
			id++;
			if (file.isFile()) {
				/* MacOS Hidden File Check */
				if (file.getName().equals(".DS_Store"))
					continue;
				/* Create HTML Document */
				Document reviewDoc = null;
				try {
					reviewDoc = Jsoup.parse(file, "UTF-8", "http://example.com");
				} catch (IOException e) {
					e.printStackTrace();
				}
				/* Transform to Review */
//				System.out.println("reviewDoc.title(): " + reviewDoc.title());
				Review review = transformDocToReview(reviewDoc);
				review.setId(id);
				reviews.add(review);
			}
		}
		System.out.println("Number of Reviews: " + reviews.size());
		return reviews;
	}

	public static void migrate() {
		System.out.println();
		System.out.println("x----------------------x");
		System.out.println("Extracting Reviews from Source...");
		System.out.println();
		/* Extract reviews from source */
		List<Review> reviews = extractReviews();
		/* Add each review to MongoDB */
		System.out.println();
		System.out.println("Adding Reviews to Local Database...");
		System.out.println("Please be patient...");
		StringBuilder sb = new StringBuilder();
		sb.append(CSV.REVIEWS_HEADING);
		for (Review review : reviews)
			sb.append(review.convertToCSV());
		CSV.writeReviews(sb.toString());
//		for (Review review : reviews)
//			ReviewCollection.getInstance().add(review);
		System.out.println("Reviews migrated successfully!");
		System.out.println("x----------------------x");
	}
	
}
