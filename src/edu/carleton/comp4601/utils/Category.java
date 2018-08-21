package edu.carleton.comp4601.utils;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Category {

	public static boolean isComedy(String summary){
		return summary.contains("comedy") || summary.contains("laugh") || summary.contains("funny") || summary.contains("comical");
	}
	
	public static boolean isDrama(String summary){
		return summary.contains("drama") || summary.contains("humorous") || summary.contains("struggles") || summary.contains("emotional");
	}
	
	public static boolean isFamily(String summary){
		return summary.contains("family") || summary.contains("father") || summary.contains("mother") || summary.contains("love");
	}
	
	public static boolean isHorror(String summary){
		return summary.contains("horror") || summary.contains("scare") || summary.contains("frighten") || summary.contains("suspense") || summary.contains("violence");
	}

	public static String getGenre(Document pageHTMLDoc){
		List<String> reviews = new ArrayList<>();
		for (Element element : pageHTMLDoc.getElementsByTag("p"))
			reviews.add(element.text());
		int numComedy = 0;
		int numDrama = 0;
		int numFamily = 0;
		int numHorror = 0;
		int numOther = 0;
		for (String review : reviews){
			String genre = (Category.isComedy(review) ? "comedy" : "other");
			genre = (Category.isDrama(review) ? "drama" : genre);
			genre = (Category.isFamily(review) ? "family" : genre);
			genre = (Category.isHorror(review) ? "horror" : genre);
			numComedy = (genre.equals("comedy") ? numComedy + 1 : numComedy);
			numDrama = (genre.equals("drama") ? numDrama + 1 : numDrama);
			numFamily = (genre.equals("family") ? numFamily + 1 : numFamily);
			numHorror = (genre.equals("horror") ? numHorror + 1 : numHorror);
			numOther = (genre.equals("other") ? numOther + 1 : numOther);
		}
//		System.out.printf("\n%d - %d - %d - %d - %d\n", numComedy, numDrama, numFamily, numHorror, numOther);
		if (numComedy >= numDrama && numComedy >= numFamily && numComedy >= numHorror && numComedy >= numOther)
			return "comedy";
		if (numDrama >= numComedy && numDrama >= numFamily && numDrama >= numHorror && numDrama >= numOther)
			return "drama";
		if (numFamily >= numComedy && numFamily >= numDrama && numFamily >= numHorror && numFamily >= numOther)
			return "family";
		if (numHorror >= numComedy && numHorror >= numDrama && numHorror >= numFamily && numHorror >= numOther)
			return "horror";
		if (numOther >= numComedy && numOther >= numDrama && numOther >= numFamily && numOther >= numHorror)
			return "other";
		return "";
	}
	
}
