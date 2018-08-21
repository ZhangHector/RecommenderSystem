package edu.carleton.comp4601.computer;

import java.util.List;
import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.utils.CSV;

/**
 * @author Hector Zhang & Rui Li
 */
public class FeatureComputation {
	
	public static void computeUserFeatures() {
		System.out.println("x----------------------x");
		System.out.println("USER FEATURE COMPUTATION INITIATING...");
		System.out.println();
		/* Retrieve ALL USERS */
		List<User> allUsers = CSV.readUsers();
		System.out.println("Number of Users: " + allUsers.size());
		System.out.println("Computing Genre...");
		FeatureComputer feature = new GenreComputer();
		feature.computeFeatureForAll(allUsers);
		System.out.println("Done.");
		/* Update all users in Database */
		System.out.println("\nUpdating in Local Database...");

		StringBuilder sb = new StringBuilder();
		sb.append(CSV.USERS_HEADING);
		for (User user : allUsers)
			sb.append(user.convertToCSV());
		CSV.writeUsers(sb.toString());
		
		System.out.println("USER FEATURE COMPUTATION COMPLETE!");
		System.out.println("x----------------------x");
	}

}
