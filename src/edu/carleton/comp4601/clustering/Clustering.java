package edu.carleton.comp4601.clustering;

import java.util.List;

import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.model.UserCluster;
import edu.carleton.comp4601.utils.CSV;

/**
 * @author Hector Zhang & Rui Li
 */
public class Clustering {
	
	public static void execute() {
		System.out.println("x----------------------x");
		System.out.println("USER CLUSTERING INITIATING...");
		System.out.println();
		System.out.println("Retrieving All Users...");
		List<User> allUsers = CSV.readUsers();
		KMeans clustering = new KMeans(5, allUsers);
		List<UserCluster> clusteredUsers = clustering.execute();
		System.out.println("Total distance: " + clustering.getDistance());
		System.out.println("Clustered Users: " + clusteredUsers.size());
		System.out.println("Adding to Local Database...");
		StringBuilder sb = new StringBuilder();
		sb.append(CSV.USER_CLUSTER_HEADING);
		for (UserCluster user : clusteredUsers)
			sb.append(user.convetToCSV());
		CSV.writeUserCluster(sb.toString());
		System.out.println();
		System.out.println("USER CLUSTERING COMPLETE!");
		System.out.println("x----------------------x");
	}

}
