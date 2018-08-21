package edu.carleton.comp4601.utils;

public class Constants {
	
	public static String RAW_DATA_RESOURCE_DIR			= "/Users/Hun/Documents/Eclipse/Workspace/COMP4601-RS/resource";
	public static String RAW_DATA_PATH_BASE 			= "/Users/Hun/Documents/Eclipse/Workspace/COMP4601-RS/dataset";
	public static String RAW_DATA_PATH_USERS 			= RAW_DATA_PATH_BASE + "/users";
	public static String RAW_DATA_PATH_MOVIES 			= RAW_DATA_PATH_BASE + "/pages";
	public static String RAW_DATA_PATH_REVIEWS 			= RAW_DATA_PATH_BASE + "/reviews";

	public static final String LOCALHOST				= "localhost";
	public static final String DB_NAME 					= "rs";
	
	public static final String GENRE_COMEDY 			= "comedy";
	public static final String GENRE_DRAMA 				= "drama";
	public static final String GENRE_FAMILY 			= "family";
	public static final String GENRE_FANTASY 			= "fantasy";
	public static final String GENRE_HORROR 			= "horror";
	public static final String GENRE_OTHER 				= "other";
	
	public static final int NUM_CLUSTERS 				= 4;
	public static final int OPTIMISM_THRESHOLD 			= 7;
	public static final int RELIABILITY_THRESHOLD		= 5;
	
	public static final int LOW_OPTIMISM 				= 0;
	public static final int HIGH_OPTIMISM 				= 1;
	public static final int LOW_RELIABILITY 			= 0;
	public static final int HIGH_RELIABILITY 			= 1;

	public static int TOTAL_ITEMS_USERS					= 1252;
	public static int TOTAL_ITEMS_MOVIES				= 1079;
	public static int TOTAL_ITEMS_REVIEWS				= 82201;
	public static int TOTAL_ITEMS_TO_MIGRATE 			= 84532;

	public static void updatePath(String dir){
		RAW_DATA_PATH_BASE 		= dir;
		RAW_DATA_PATH_USERS 	= RAW_DATA_PATH_BASE + "/users";
		RAW_DATA_PATH_MOVIES 	= RAW_DATA_PATH_BASE + "/pages";
		RAW_DATA_PATH_REVIEWS 	= RAW_DATA_PATH_BASE + "/reviews";
	}
	
	public static void updateTotalItemsUsers(int num)	{	TOTAL_ITEMS_USERS = num;		}
	public static void updateTotalItemsMovies(int num)	{	TOTAL_ITEMS_MOVIES = num;		}
	public static void updateTotalItemsReviews(int num) {	TOTAL_ITEMS_REVIEWS = num;		}
	
	public static void updateTotalItemToMigrate(){	
		TOTAL_ITEMS_TO_MIGRATE = TOTAL_ITEMS_USERS + TOTAL_ITEMS_MOVIES + TOTAL_ITEMS_REVIEWS;	
	}
}
