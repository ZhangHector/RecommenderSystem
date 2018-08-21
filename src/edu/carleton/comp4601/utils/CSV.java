package edu.carleton.comp4601.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.carleton.comp4601.clustering.KMeans;
import edu.carleton.comp4601.model.Advertisement;
import edu.carleton.comp4601.model.Cluster;
import edu.carleton.comp4601.model.Movie;
import edu.carleton.comp4601.model.Review;
import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.model.UserCluster;

public class CSV {

	public static final String DATABASE_DIR 			= "/Users/Hun/Documents/Eclipse/Workspace/COMP4601-RS/resource/";
	public static final String REVIEWS_CSV 				= "reviews.csv";
	public static final String USERS_CSV 				= "users.csv";
	public static final String MOVIES_CSV 				= "movies.csv";
	public static final String USER_CLUSTER_CSV			= "user_cluster.csv";
	public static final String CLUSTER_CSV				= "cluster.csv";
	public static final String CENTER_USER_CSV			= "center_user.csv";
	public static final String ADVERTISEMENT_CSV		= "advertisement.csv";

	public static final String REVIEWS_HEADING 			= "id, userName, movieName, score, helpfulness, genre\n";
	public static final String USERS_HEADING			= "name, comedy, drama, family, horror, other\n";
	public static final String MOVIES_HEADING			= "name, genre\n";
	public static final String USER_CLUSTER_HEADING		= "name, cluster\n";
	public static final String CLUSTER_HEADING 			= "cluster, comedyClass, dramaClass, familyClass, horrorClass, otherClass\n";
	public static final String CENTER_USER_HEADING 		= "cluster, comedyClass, dramaClass, familyClass, horrorClass, otherClass\n";
	public static final String ADVERTISEMENT_HEADING	= "title, caption, visual, comedyClass, dramaClass, familyClass, horrorClass, otherClass\n";
	
	public static final String COMMA 					= ",";
	
	public static void writeReviews(String dataset)			{	write(dataset, REVIEWS_CSV);		}
	public static void writeUsers(String dataset)			{	write(dataset, USERS_CSV);			}
	public static void writeMovies(String dataset)			{	write(dataset, MOVIES_CSV);			}
	public static void writeUserCluster(String dataset)		{	write(dataset, USER_CLUSTER_CSV);	}
	public static void writeCluster(String dataset)			{	write(dataset, CLUSTER_CSV);		}
	public static void writeCenterUser(String dataset)		{	write(dataset, CENTER_USER_CSV);	}
	public static void writeAdvertisement(String dataset)	{	write(dataset, ADVERTISEMENT_CSV);	}
	
	public static void write(String dataset, String fileName){
        try {
			PrintWriter pw = new PrintWriter(new File(DATABASE_DIR + fileName));
			pw.write(dataset);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<Review> readReviws()	{ 
        List<Review> reviews = new ArrayList<>();
        for(List<String> list : read(REVIEWS_CSV)){
    		Review review = new Review();
    		try{
    			review.setId(Integer.parseInt(list.get(0)));
        		review.setUserName(list.get(1));
        		review.setMovieName(list.get(2));
        		review.setScore(Double.parseDouble(list.get(3)));
        		review.setHelpfulness(Double.parseDouble(list.get(4)));
        		review.setGenre(list.get(5));
        		reviews.add(review);
    		} catch (Exception e) {
    			System.out.println("ID: " + list.get(1));
    			System.out.println("User Name: " + list.get(1));
    			System.out.println("Movie Name: " + list.get(2));
    		}
        }
		return reviews;	
	}
	
	public static List<User> readUsers()	{ 
        List<User> users = new ArrayList<>();
        for(List<String> list : read(USERS_CSV)){
        	User user = new User();
        	user.setName(list.get(0));
        	user.setComedy(Double.parseDouble(list.get(1)));
        	user.setDrama(Double.parseDouble(list.get(2)));
        	user.setFamily(Double.parseDouble(list.get(3)));
        	user.setHorror(Double.parseDouble(list.get(4)));;
        	user.setOther(Double.parseDouble(list.get(5)));
        	users.add(user);
        }
		return users;	
	}
	
	public static List<Movie> readMovies()	{ 
        List<Movie> movies = new ArrayList<>();
        for(List<String> list : read(MOVIES_CSV)){
        	Movie movie = new Movie();
        	movie.setName(list.get(0));
        	movie.setGenre(list.get(1));
        	movies.add(movie);
        }
		return movies;	
	}
	
	public static List<UserCluster> readUserCluster()	{ 
        List<UserCluster> userClusters = new ArrayList<>();
        for(List<String> list : read(USER_CLUSTER_CSV)){
        	UserCluster userCluster = new UserCluster();
        	userCluster.setName(list.get(0));
        	userCluster.setCluster(Integer.parseInt(list.get(1)));
        	userClusters.add(userCluster);
        }
		return userClusters;	
	}
	
	public static List<Cluster> readCluster()	{ 
        List<Cluster> clusters = new ArrayList<>();
        for(List<String> list : read(CLUSTER_CSV)){
        	Cluster cluster = new Cluster();
        	cluster.setCluster(Integer.parseInt(list.get(0)));
        	cluster.setComedyClass(Integer.parseInt(list.get(1)));
        	cluster.setDramaClass(Integer.parseInt(list.get(2)));
        	cluster.setFamilyClass(Integer.parseInt(list.get(3)));
        	cluster.setHorrorClass(Integer.parseInt(list.get(4)));
        	cluster.setOtherClass(Integer.parseInt(list.get(5)));
        	clusters.add(cluster);
        }
		return clusters;	
	}

	public static List<Cluster> readCenterUser()	{ 
        List<Cluster> clusters = new ArrayList<>();
        for(List<String> list : read(CENTER_USER_CSV)){
        	Cluster centerCluster = new Cluster();
        	centerCluster.setCluster(Integer.parseInt(list.get(0)));
        	centerCluster.setComedyClass(Integer.parseInt(list.get(1)));
        	centerCluster.setDramaClass(Integer.parseInt(list.get(2)));
        	centerCluster.setFamilyClass(Integer.parseInt(list.get(3)));
        	centerCluster.setHorrorClass(Integer.parseInt(list.get(4)));
        	centerCluster.setOtherClass(Integer.parseInt(list.get(5)));
        	clusters.add(centerCluster);
        }
		return clusters;	
	}

	public static List<Advertisement> readAdvertisement()	{ 
        List<Advertisement> advertisements = new ArrayList<>();
        for(List<String> list : read(ADVERTISEMENT_CSV)){
        	Advertisement advertisement = new Advertisement();
        	advertisement.setTitle(list.get(0));
        	advertisement.setCaption(list.get(1));
        	advertisement.setVisual(list.get(2));
        	if (list.get(3) != null && !list.get(3).equals("null"))
        		advertisement.setComedyClass(Integer.parseInt(list.get(3)));
        	if (list.get(4) != null && !list.get(4).equals("null"))
        		advertisement.setDramaClass(Integer.parseInt(list.get(4)));
        	if (list.get(5) != null && !list.get(5).equals("null"))
        		advertisement.setFamilyClass(Integer.parseInt(list.get(5)));
        	if (list.get(6) != null && !list.get(6).equals("null"))
        		advertisement.setHorrorClass(Integer.parseInt(list.get(6)));
        	if (list.get(7) != null && !list.get(7).equals("null"))
        		advertisement.setOtherClass(Integer.parseInt(list.get(7)));
        	advertisements.add(advertisement);
        }
		return advertisements;	
	}
	
	
	public static List<List<String>> read(String fileName){
		List<List<String>> dataset = new ArrayList<>();
        String line = "";
        try {
        	BufferedReader br = new BufferedReader(new FileReader(DATABASE_DIR + fileName));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(COMMA);
                List<String> rawdata = Arrays.asList(data);
                dataset.add(rawdata);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataset.subList(1, dataset.size());
	}
	
	public static void main(String[] args) {
		System.out.println("x----------------------x");
		System.out.println("USER CLUSTERING INITIATING...");
		System.out.println();
		System.out.println("Retrieving All Users...");
		List<User> allUsers = CSV.readUsers();
//		KMeans clustering = new KMeans(2, allUsers);
		KMeans clustering = new KMeans(6, allUsers);
		List<UserCluster> clusteredUsers = clustering.execute();
		System.out.println("Clustered Users: " + clusteredUsers.size());
		System.out.println("Adding to Local database...");
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
