package edu.carleton.comp4601.classification;

import java.util.List;

import edu.carleton.comp4601.model.Cluster;
import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.utils.CSV;

/**
 * @author Hector Zhang & Rui Li
 */
public class Classifier {
	
	public static void classify() {
		System.out.println("x----------------------x");
		System.out.println("CLASSIFIER INITIATING...");
		System.out.println();
		System.out.println("Retrieving Clusters from Local Database...");
		System.out.println("\nClassfying the clusters...");
		List<Cluster> clusters = CSV.readCenterUser();
		StringBuilder sb = new StringBuilder();
		sb.append(CSV.CLUSTER_HEADING);
		for (Cluster cluster : clusters)
			sb.append(cluster.convertToCSV());
		CSV.writeCluster(sb.toString());
		System.out.println();
		System.out.println("CLASSIFICATION COMPLETE!");
		System.out.println("x----------------------x");
	}
	
	public static User findUser(List<User> users, String name){
		for (User user : users)
			if (user.getName().equals(name))
				return user;
		return null;
	}
	
	public static double averageComedy(List<User> cluster) {
		double totalComedy = 0;
		int numComedy = 0;
		for(User user: cluster)
			if (user.getComedy() > 0){
				totalComedy += user.getComedy();
				numComedy++;
			}
		return totalComedy/numComedy;
	}
	
	public static double averageDrama(List<User> cluster) {
		double totalDrama = 0;
		int numDrama = 0;
		for(User user: cluster)
			if (user.getDrama() > 0){
				totalDrama += user.getDrama();
				numDrama++;
			}
		return totalDrama/numDrama;
	}
	
	public static double averageFamily(List<User> cluster) {
		double totalFamily = 0;
		int numFamily = 0;
		for(User user: cluster)
			if (user.getFamily() > 0){
				totalFamily += user.getFamily();
				numFamily++;
			}
		return totalFamily/numFamily;
	}
	
	public static double averageHorror(List<User> cluster) {
		double totalHorror = 0;
		for(User user: cluster)
			totalHorror += user.getHorror();
		return totalHorror/cluster.size();
	}
	
	public static double averageOther(List<User> cluster) {
		double totalOther = 0;
		int numOther = 0;
		for(User user: cluster)
			if (user.getOther() > 0){
				totalOther += user.getOther();
				numOther++;
			}
		return totalOther/numOther;
	}
	
	public static void main(String[] args) {
		classify();
	}

}
