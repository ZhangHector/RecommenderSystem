package edu.carleton.comp4601.migration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.utils.CSV;
import edu.carleton.comp4601.utils.Constants;

/**
 * @author Hector Zhang & Rui Li
 */
public class UserMigration {
	
	public static List<User> extractUsers() {
		List<User> users = new ArrayList<User>();
		File folder = new File(Constants.RAW_DATA_PATH_USERS);
		File[] listOfFiles = folder.listFiles();
		System.out.println("Number of Files: " + listOfFiles.length);
		System.out.println("Number of Users: " + users.size());
		System.out.println("Creating Users...");
		Constants.updateTotalItemsUsers(users.size());
		for (File file : listOfFiles) {
			if(file.isFile()) {
				if (file.getName().equals(".DS_Store"))
					continue;
				/* Create New User */
				User user = new User();
				user.setName(file.getName().replaceAll(".html", ""));
				users.add(user);
			}
		}
		System.out.println("Number of Users: " + users.size());
		return users;
	}
	
	public static void migrate() {
		System.out.println("x----------------------x");
		System.out.println("Extracting Users from Source...");
		/* Extract users from source */
		List<User> users = extractUsers();
		/* Add each user to MongoDB */
		System.out.println();
		System.out.println("Adding Users to Local Database...");
		StringBuilder sb = new StringBuilder();
		sb.append(CSV.USERS_HEADING);
		for (User user : users)
			sb.append(user.convertToCSV());
		CSV.writeUsers(sb.toString());
		System.out.println("Users migrated successfully!");
		System.out.println("x----------------------x");
	}
	
	public static void main(String[] args) {
		System.out.println("Number of Files: " + new File(Constants.RAW_DATA_PATH_USERS).listFiles().length);
		System.out.println("Number of Users: " +  new ArrayList<User>().size());
	}

}
