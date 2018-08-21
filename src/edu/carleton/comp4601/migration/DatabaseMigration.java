package edu.carleton.comp4601.migration;

/**
 * MIGRATES THE FULL DATABASE
 * FROM A DIRECTORY TO MONGO DB.
 * @author Hector Zhang & Rui Li
 */
public class DatabaseMigration {

	/**
	 * TODO: 2. There are >1000 users who use these pages. 
	 * The page access profiles for these users are stored in the users directory. 
	 * The patterns are "real". The profiles are stored as web pages. 
	 * The links indicate the pages that have been accessed by the users. 
	 * NOTE: There may be multiple links to the same page. 
	 * The title tag indicates the name of the user. 
	 * The image above provides a visual representation of the interaction between users, 
	 * pages and the underlying social network, which is stored in the graph directory.
	 * TODO: 3. Using the information in (1) and (2) you are to compute profiles 
	 * for the users based upon document content and access patterns. 
	 * Archives of the data from (1) and (2) may be found in the archive directory.
	 * */
	public static void migrate() {
		System.out.println("x----------------------x");
		System.out.println("DATABASE MIGRATION INITIATING...");
		System.out.println();
		UserMigration.migrate();
		MovieMigration.migrate();
		ReviewMigration.migrate();
		System.out.println();
		System.out.println("DATABASE MIGRATION COMPLETE!");
		System.out.println("x----------------------x");
	}
	
}
