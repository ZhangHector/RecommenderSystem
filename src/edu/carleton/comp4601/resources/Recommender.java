package edu.carleton.comp4601.resources;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.carleton.comp4601.migration.DatabaseMigration;
import edu.carleton.comp4601.model.Advertisement;
import edu.carleton.comp4601.model.Cluster;
import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.model.UserCluster;
import edu.carleton.comp4601.utils.AdvertisementFactory;
import edu.carleton.comp4601.utils.CSV;
import edu.carleton.comp4601.utils.Category;
import edu.carleton.comp4601.utils.Configuration;
import edu.carleton.comp4601.utils.Constants;
import edu.carleton.comp4601.utils.ContextInitializer;
import edu.carleton.comp4601.utils.HTMLBuilder;

/**
 * Recommender System
 * @author Hector Zhang & Rui Li 
 */
@Path("/rs")
public class Recommender {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	private static final String NAME = "COMP4601 Recommender System: Hector Zhang & Rui Li";

	/**
	 * Get request for the name of SDA 
	 * @param 
	 * @return String name 
	 * @throws
	 */
	@GET
	public String printName() {
		return NAME;
	}

	/**
	 * Get request for the main XML page 
	 * @param 
	 * @return XML String 
	 * @throws
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXML() {
		return "<?xml version=\"1.0\"?>" + "<sda> " + NAME + " </sda>";
	}

	/**
	 * Get request for the main HTML page 
	 * @param 
	 * @return HTML String 
	 * @throws
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtml() {
		return "<html> " + "<title>" + NAME + "</title>" + "<body><h1>" + NAME + "</body></h1>" + "</html> ";
	}

	/**
	 * Get request for the main JSON page @param 
	 * @return JSON String 
	 * @throws
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJSON() {
		return "{" + NAME + "}";
	}
	
	
	
	/**
	 * 1.	Migrate Data to MongoDB
	 * 		User Model:			Name,	Optimism,	Reliability
	 * 		Movie Model:		Name
	 * 		Review Model:	UsreName,	MovieName,	Score,			Helpfulness
	 * 2.	Feature Computation
	 * Scores and helpfulness of the users to create the recommender system.
	 * Using personal decisions made for recommendation of advertising
	 * "real" users have made reviews on a list of "real" movies
	 * Helpfulness of the review by thumbs up or thumbs down
	 * The features(User Model): 
	 * 		the scores from user's every movies' review
	 * 		the helpfulness rating they received from others users
	 * 		total value of scores and helpfulness for every review(Each User):
	 * 		average values for each field used as FEATURE
	 * 		Average Score -> Optimism
	 * 		Average Helpfulness -> Reliability
	 * 3.	Determining Communities
	 * Using the K-means algorithm
	 * Four possible outcomes(Cluster Outcomes):
	 * 		Optimism -> HIGH && Reliability _> HIGH
	 * 		Optimism -> LOW && Reliability _> LOW
	 * 		Optimism -> HIGH && Reliability _> LOW
	 * 		Optimism -> LOW && Reliability _> HIGH
	 * Cluster Model:
	 * 		User Id
	 * 		Cluster
	 * Cluster Collection for MongoDB
	 * 4.	Classification of Communities
	 * Custom Classifier: Average optimism and reliability of each community(Cluster)
	 * Custom threshold for each feature in a specific category
	 * 		Above Threshold -> High
	 * 		Below Threshold -> Low
	 * 5.	Creating Advertisements
	 * Based on the classification of the communities
	 * Community: Optimism and Reliability
	 * HIGH/LOW: respective category
	 * Example:	/fetch/{user}/{page}
	 * 		Take the user
	 * 		Find the community,
	 * 		Retrieve the HIGH/LOW ranking of Optimistic and Reliable fields
	 * Using the ranking, it will augment different advertisements on the specified page,
	 * according to the ranking of the user's community.
	 * Advertising Content:
	 * 		High Reliability
	 * 		Low Reliability
	 * 		High Optimism
	 * 		Low Optimism
	 * Communities Found After Clustering
	 * 		Community 1:
	 * 			Optimism: LOW -> Reliability: LOW
	 * 		Community 2:
	 * 			Optimism: HIGH -> Reliability: LOW
	 * 		Community 3:
	 * 			Optimism: HIGH -> Reliability: HIGH
	 * 		Community 4:
	 * 			Optimism: HIGH -> Reliability: HIGH
	 * 
	 * Suggest Algorithm
	 * Assumptions:
	 * 		Pages is a movie
	 * 		The New User has connections with the graph
	 * 		Communities have been determined
	 * 		Optimism and Reliability of the users have been computed
	 * 		Community specific advertisements have been created
	 * 
	 * Pages:
	 * 		Taking a New User as input
	 * 		Output list of Pages
	 * 		1.	Calculated average score of all movies
	 * 			retrieves top five
	 * 		2.	Find top five movies reviewed by every connected user
	 * 			Combine the two top five lists,
	 * 			Return top 10 suggested movies for the new user
	 * 
	 * Advertisement
	 * 		Take New User as input
	 * 		Output list of Advertisement
	 * 		1.	Find the most recurring cluster id(community) of the new user's connections in the graph
	 * 		2.	Community is dominant in the new user's connections
	 * 		3.	Corresponding advertisements will be output from the algorithm
	 * 
	 * Pages:
	 * 		Input:		New User, U
	 * 		Output:		List of Pages
	 * 
	 * 		for each movie
	 * 			calculate average review score
	 * 		topFiveMovies <- Retrieve Top 5 Movies
	 * 		for each connection C of New User
	 * 			find top 3 reviews made by C
	 * 			topReviews <- add top 3
	 * 		connectedMovies <- retrieve top 5 of topReviews
	 * 		created new listMovies
	 * 		listMovies <- topFiveMovies + connectedMovies
	 * 		output listMovies
	 * 
	 * Advertisement
	 * 		Input:		New User, U
	 * 		Output:		List of Advertisements
	 * 		
	 * 		for each connection C of New User
	 * 			C.ID <- Retrieve Cluster Id
	 * 			add C.ID to clusterIdList
	 * 		Recurring Cluster <- find most Recurring Element of ClusterId
	 * 		Output Recurring Clusters's Advertisements
	 * */
	
	
	/**
	 * TODO: 7. You are to implement a RESTful web service /reset/{dir} using GET that initializes your system. 
	 * This service should then allow the web services in (8)-(12) below to run. 
	 * This service is a testing convenience only. 
	 * Here, dir represents the directory being used as the root directory for access to web pages and users. 
	 * This will be used during testing to access testing data (the data referenced here is training data). 
	 * For example, while training the value of dir will be "training" reflecting the use of the data 
	 * in the comp4601/assignments/training directory; 
	 * however, a tester might choose dir = "testing" to access data in the comp4601/assignments/testing/pages 
	 * and comp4601/assignments/testing/users directories.
	 * */	
	@GET
	@Path("/reset/{dir}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reset(@PathParam("dir") String dir) {
		System.out.println("x---------x");
		System.out.println("Request Type: GET Reset Dir");
		System.out.println("Databse currently resetting...");		
		System.out.println("Resetting DB flag...");
		try {
			FileUtils.cleanDirectory(new File(Constants.RAW_DATA_RESOURCE_DIR));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constants.updatePath("/Users/Hun/Documents/Eclipse/Workspace/COMP4601-RS/" + dir);
		System.out.println(Constants.RAW_DATA_PATH_BASE);
		new Thread(new Runnable() {
			@Override
			public void run() {
				/* Create new configuration settings */
				Configuration.reset();
				System.out.println("Creating new Configuration Settings...");
				System.out.println("Migrating data in the background... Please wait for completion update.");
				/* Initiate Migration Sequence */
				System.out.println(Constants.RAW_DATA_PATH_USERS);
				System.out.println(Constants.RAW_DATA_PATH_MOVIES);
				System.out.println(Constants.RAW_DATA_PATH_REVIEWS);
				DatabaseMigration.migrate();
				/* Data has been migrated, update Config */
				Configuration.write(Configuration.DATA_MIGRATED);
				System.out.println("Updating Migration Property...");
				System.out.println("Data has been migrated successfully!");
				System.out.println("x---------x");
			}
		}).start();
		System.out.println("Database currently migrating. Please be patient.");
		String html = HTMLBuilder.buildFailure("Database currently migrating...");
		Response response = Response.ok(html, MediaType.TEXT_HTML).build();
		System.out.println("x---------x");
		return response;
	}

	/**
	 * TODO: 5. You are to design a contextual advertising system. 
	 * That is, when a user requests a page, the page will be retrieved and augmented with advertising. 
	 * Review lecture 14 notes on Content Augmentation if contextual advertising is unclear to you.
	 * TODO: 10. You are to implement a RESTful web service /fetch/{user}/{page} using GET that 
	 * retrieves a page from the context specified in (8) (a testing set will be specified after the submission deadline) 
	 * and augments it with advertising. 
	 * Your web service must consist of 2 frames, one containing the content of the requested page, 
	 * and the other containing advertising.
	 * TODO: 11. You are to document the communities that you have found in analyzing the test data 
	 * in the web pages and users provided. 
	 * Furthermore, you must document how you created your advertising content and 
	 * the mechanism used to retrieve it when using the /fetch/{user}/{page} service.
	 * */	
	@GET
	@Path("/fetch/{user}/{page}")
	@Produces(MediaType.TEXT_HTML)
	public Response displayAugmentedPage(@PathParam("page") String pageTitle, @PathParam("user") String userName) {
		System.out.println("x---------x");
		System.out.println("Request Type: GET Display Advertisement Augmented Page");
		Response response = null;
		String html = null;
		if (!Configuration.read().contains(Configuration.CONTEXT_INITIALIZED)){
			System.out.println("Context has NOT been initialized. " + "\nReturning Error Message.");
			html = HTMLBuilder.buildFailure("Context needs to be " + "initialized before pages are viewable.");
			response = Response.ok(html, MediaType.TEXT_HTML).build();
			return response;
		}
		System.out.println();
		System.out.println("Page Requested: " + pageTitle);
		System.out.println("Page Requested By User: " + userName);
		System.out.println("Retrieving File...");
		File file = new File(Constants.RAW_DATA_PATH_MOVIES + "/" + pageTitle + ".html");
		System.out.println("File: " + file);
		System.out.println("Parsing File...");
		Document pageHTMLDoc = null;
		try {
			pageHTMLDoc = Jsoup.parse(file, "UTF-8", "http://example.com");
		} catch (IOException e) {
			pageHTMLDoc = null;
			e.printStackTrace();
		}
		System.out.println();
		
//		System.out.println(pageHTMLDoc);
		System.out.println("Computing the genre of the movie");
		String genre = Category.getGenre(pageHTMLDoc);
		System.out.println("Genre of the move(Page): " + genre);
		/* Find User's Cluster ID */
		System.out.println("Finding Cluster ID of " + userName + "...");
		UserCluster userCluster = null;
		for (UserCluster tempUserCluster : CSV.readUserCluster())
			if (tempUserCluster.getName().equals(userName)){
				userCluster = tempUserCluster;
				break;
			}
		System.out.println(userCluster);
		/* Find Clusters Class */
		System.out.println("Finding Clusters Class...");
		Cluster cluster = null;
		for (Cluster tempCluster : CSV.readCluster())
			if (tempCluster.getCluster() == userCluster.getCluster()){
				cluster = tempCluster;
				break;
			}
		System.out.println(cluster);
		/* Display Appropriate content to user according to specified cluster */
		System.out.println("Retrieving Following Advertisements:");
		Advertisement ad = AdvertisementFactory.findByCommunityAndGenre(cluster.getCluster(), genre);
		System.out.println("Ad is retrieved.");
		System.out.println("Creating augmented page...");
		html = HTMLBuilder.augmentAdvertisement(pageHTMLDoc.body().html(), ad);
		System.out.println("Responding...");
		response = Response.ok(html, MediaType.TEXT_HTML).build();
		System.out.println("x---------x");
		return response;
	}

	/**
	 * TODO: 8. You are to implement a RESTful web service /context using GET that analyzes the web pages and 
	 * returns an HTML representation of the profiles for users. 
	 * The HTML returned must clearly show what features are being used as part of the profile for a user. 
	 * It is expected that the response would contain an HTML table with one row containing information for a user.
	 * */	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_HTML)
	public Response getContext() {
		System.out.println("x---------x");
		System.out.println("Request Type: GET Context");
		Response response = null;
		String html = null;
		if (!Configuration.read().contains(Configuration.DATA_MIGRATED)){
			System.out.println("Database currently migrating. Please be patient.");
			html = HTMLBuilder.buildFailure("Database currently migrating...");
			response = Response.ok(html, MediaType.TEXT_HTML).build();
			System.out.println("x---------x");
			return response;
		}
		if (!Configuration.read().contains(Configuration.CONTEXT_COMPUTING)){
			System.out.println("Context has NOT been initialized. " + "\nExecuting initialization sequence.");
			Configuration.write(Configuration.CONTEXT_COMPUTING);
			new Thread(new Runnable(){
				@Override
				public void run() {
					/* Initialize Context */
					ContextInitializer.initialize();
					System.out.println("Context has already been initialized.");
				}
			}).start();
		}
		if (Configuration.read().contains(Configuration.CONTEXT_INITIALIZED)){
			/* Extract all the users from the DB */
			System.out.println("Extracting all users...");
			List<User> users = CSV.readUsers();
			System.out.println("Numer of users retrieved: " + users.size());
			System.out.println("Creating table...");
			html = HTMLBuilder.buildContextTable(users);
			response = Response.ok(html, MediaType.TEXT_HTML).build();
			System.out.println("x---------x");
			return response;
		}
		html = HTMLBuilder.buildFailure("Currently executing initialization sequence...");
		response = Response.ok(html, MediaType.TEXT_HTML).build();
		System.out.println("x---------x");
		return response;
	}
	
	/**
	 * TODO: 12. You are to implement a RESTful web service /advertising/{category} using GET that 
	 * returns an HTML representation of the advertising category that you have designed. 
	 * Here, category would be C-X, X = 1, ..., m. NOTE: It is reasonable to expect that 
	 * several pieces of advertising would be provided for a particular community. 
	 * This is for you to design and document.
	 * */
	@GET
	@Path("/advertising/{category}")
	@Produces(MediaType.TEXT_HTML)
	public Response getAdvertisingCategory(@PathParam("category") String category) {
		System.out.println("x---------x");
		System.out.println("Request Type: GET Advertising Category");
		Response response = null;
		String html = null;
		if (!Configuration.read().contains(Configuration.CONTEXT_INITIALIZED)){
			System.out.println("Context has NOT been initialized. " + "\nReturning Error Message.");
			html = HTMLBuilder.buildFailure("Context needs to be " + "initialized before advertisements are viewable.");
			response = Response.ok(html, MediaType.TEXT_HTML).build();
			return response;
		}
		System.out.println("Ads requested for category: " + category);
		/* Retrieve Cluster */
		System.out.println("Retrieving cluster from Local Database...");
		System.out.println("Retrieving community ads...");
		if (Integer.parseInt(category) < 1 || Integer.parseInt(category) > 5){
			System.out.println("Community value is invalid. Please enter the correct community value.");
			html = HTMLBuilder.buildFailure("Community value is invalid.");
			response = Response.ok(html, MediaType.TEXT_HTML).build();
			System.out.println("x---------x");
			return response;
		}
		List<Advertisement> ads = AdvertisementFactory.findByCommunity(Integer.parseInt(category) - 1);
		System.out.println("Creating html...");
		html = HTMLBuilder.buildAdCategory(ads);
		response = Response.ok(html, MediaType.TEXT_HTML).build();
		System.out.println("x---------x");
		return response;
	}

	/**
	 * TODO: 9. You are to implement a RESTful web service /community using GET that, if run after the /context web service, 
	 * returns an HTML representation of the communities computed for the users. 
	 * The HTML must contain a table in which each row contains the community name (C-X, X = 1,..., m) 
	 * followed by a cell containing a comma delimited list of user names. 
	 * Should the community service be run before the context service an error should be generated.
	 * */	
	@GET
	@Path("/community")
	@Produces(MediaType.TEXT_HTML)
	public Response getCommunities() {
		System.out.println("x---------x");
		System.out.println("Request Type: GET Communities");
		Response response = null;
		String html = null;
		if (!Configuration.read().contains(Configuration.CONTEXT_INITIALIZED)){
			System.out.println("Context has NOT been initialized. \nReturning Error Message.");
			html = HTMLBuilder.buildFailure("Context needs to be initialized before communities are viewable.");
			response = Response.ok(html, MediaType.TEXT_HTML).build();
			return response;
		}
		/* Get all communities */
		List<Cluster> communities = CSV.readCluster();
		html = HTMLBuilder.buildCommunitiesTable(communities);
		response = Response.ok(html, MediaType.TEXT_HTML).build();
		System.out.println("x---------x");
		return response;
	}
}
