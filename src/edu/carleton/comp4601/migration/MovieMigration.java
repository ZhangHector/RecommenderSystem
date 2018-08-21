package edu.carleton.comp4601.migration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.carleton.comp4601.model.Movie;
import edu.carleton.comp4601.utils.CSV;
import edu.carleton.comp4601.utils.Constants;

/**
 * @author Hector Zhang & Rui Li
 */
public class MovieMigration {
	
	public static List<Movie> extractMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		File folder = new File(Constants.RAW_DATA_PATH_MOVIES);
		System.out.println("Number of Files: " + folder.listFiles().length);
		System.out.println("Number of Movies: " + movies.size());
		System.out.println("Creating Movies...");		
		Constants.updateTotalItemsMovies(movies.size());
		for (File file : folder.listFiles()) {
			if(file.isFile()) {
				if (file.getName().equals(".DS_Store"))
					continue;
				/* Create New User */
				Movie movie = new Movie();
				movie.setName(file.getName().replaceAll(".html", ""));
				movies.add(movie);
			}
		}
		System.out.println("Number of Movies: " + movies.size());
		return movies;
	}
	
	public static void migrate() {
		System.out.println("x----------------------x");
		System.out.println("Extracting Movies from Source...");
		/* Extract movies from source */
		List<Movie> movies = extractMovies();
		System.out.println();
		System.out.println("Adding Movies to Local Database...");
		/* Add each movie to MongoDB */
		StringBuilder sb = new StringBuilder();
		sb.append(CSV.MOVIES_HEADING);
		for(Movie movie: movies)
			sb.append(movie.convertToCSV());
		CSV.writeMovies(sb.toString());
//		for(Movie movie: movies)
//			MovieCollection.getInstance().add(movie);
		System.out.println("Movies migrated successfully!");
		System.out.println("x----------------------x"); 
	}

}
