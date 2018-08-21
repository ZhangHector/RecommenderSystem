package edu.carleton.comp4601.utils;

import java.util.ArrayList;
import java.util.List;

import edu.carleton.comp4601.model.Advertisement;
import edu.carleton.comp4601.model.Cluster;
import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.model.UserCluster;

/**
 * @author Hector Zhang & Rui Li
 */
public class HTMLBuilder {
	
	private static final String CONTEXT = "CONTEXT";
	private static final String APP_CONTEXT = "WEB APP CONTEXT";
	private static final String ADVERTISEMENTS = "ADVERTISEMENTS";
	private static final String COMMUNITIES = "COMMUNITIES";
	
	/**
	 * Builds a three column HTML table using the  user's details.
	 * @param users the list of users to be used
	 * @return HTML representation of users' details
	 */
	public static String buildContextTable(List<User> users) {
		StringBuilder htmlDoc = new StringBuilder();
		/* BUILD HEADER */
		htmlDoc.append("<html>");
		htmlDoc.append("<head><title>" + CONTEXT + "</title></head>");
		/* BUILD BODY */
		htmlDoc.append("<body>");
		htmlDoc.append("<b><font color=\"royalblue\" size=\"6\" face=\"verdana\">" + "<center>" + APP_CONTEXT + "</center>" + "</font></b>");
		htmlDoc.append("<br/>");
		htmlDoc.append("<br/>");
		htmlDoc.append("<table style=\"width:100%\" border=\"1\">");
		/* Insert Table Headers */
		htmlDoc.append("<tr>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"4\" face=\"verdana\">" + "USERS" + "</font></b>"  + "</th>");
		htmlDoc.append("<th colspan=\"5\">" + "<b><font color=\"seagreen\" size=\"10\" face=\"verdana\">" + "FEATURES" + "</font></b>"  + "</th>");
		htmlDoc.append("</tr>");
		htmlDoc.append("<tr>");
		htmlDoc.append("<th></th>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"2\" face=\"verdana\">" + "COMEDY" + "</font></b>"  + "</th>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"2\" face=\"verdana\">" + "DRAMA" + "</font></b>"  + "</th>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"2\" face=\"verdana\">" + "FAMILY" + "</font></b>"  + "</th>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"2\" face=\"verdana\">" + "HORROR" + "</font></b>"  + "</th>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"2\" face=\"verdana\">" + "OTHER" + "</font></b>"  + "</th>");
		htmlDoc.append("</tr>");
		/* Insert Table Rows */
		for(User user: users) {
			htmlDoc.append("<tr>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(user.getName());
			htmlDoc.append("</td>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(String.format("%.4f", user.getComedy()));
			htmlDoc.append("</td>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(String.format("%.4f", user.getDrama()));
			htmlDoc.append("</td>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(String.format("%.4f", user.getFamily()));
			htmlDoc.append("</td>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(String.format("%.4f", user.getHorror()));
			htmlDoc.append("</td>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(String.format("%.4f", user.getOther()));
			htmlDoc.append("</td>");
			htmlDoc.append("</tr>");
		} 
		htmlDoc.append("</table>");
		htmlDoc.append("</body>");
		return htmlDoc.toString();
	}
	
	public static String buildAdCategory(List<Advertisement> advertisements) {
		StringBuilder response = new StringBuilder();
		response.append("<html>");
		response.append("<head><title>ADVERTISEMENTS</title></head>");
		response.append("<body>");
		response.append("<b><font color=\"red\" size=\"6\" face=\"verdana\">" + ADVERTISEMENTS + "</font></b>");
		if(advertisements == null || !advertisements.isEmpty()) {
			response.append("<ul>");
			for(Advertisement adv: advertisements) {
				response.append("<li>");
				response.append(adv.getTitle());
				response.append("</li>");
			}
			response.append("</ul>");
		} else {
			response.append("</br>");
			response.append("</br>");
			response.append("No document(s) found.");
		}
		response.append("</body>");
		return response.toString();
	}
	
	public static String augmentAdvertisement(String original, Advertisement advertisement) {
		StringBuilder htmlDoc = new StringBuilder();
		/* BUILD HEADER */
		htmlDoc.append("<html>");
		htmlDoc.append("<head><title>" + CONTEXT + "</title></head>");
		/* BUILD BODY */
		htmlDoc.append("<body>");
		htmlDoc.append("<b><font color=\"royalblue\" size=\"6\" face=\"verdana\">" + "<center>" + APP_CONTEXT + "</center>" + "</font></b>");
		htmlDoc.append("<br/>");
		htmlDoc.append("<br/>");
		htmlDoc.append("<table style=\"width:100%\" border=\"1\">");
		/* Insert Table Headers */
		htmlDoc.append("<tr>");
		htmlDoc.append("<th>" + "<b><font color=\"seagreen\" size=\"4\" face=\"verdana\">" + "Advertising" + "</font></b>"  + "</th>");
		htmlDoc.append("<th colspan=\"1\">" + "<b><font color=\"seagreen\" size=\"10\" face=\"verdana\">" + "Reviews" + "</font></b>"  + "</th>");
		htmlDoc.append("</tr>");
		/* Insert Table Rows */
		htmlDoc.append("<tr>");
		htmlDoc.append("<td valign=\"top\" align=\"center\">");
		htmlDoc.append("<div class=\"ad\">");
		htmlDoc.append("<div class=\"ad_text\">");
		htmlDoc.append("<p><center>" + advertisement.getCaption() + "</center><p>");
		htmlDoc.append("</div>");
		htmlDoc.append("<div class=\"ad_visual\">");
		htmlDoc.append("<img src=\"" + advertisement.getVisual() + "\">");
		htmlDoc.append("</div>");
		htmlDoc.append("</div>");
		htmlDoc.append("</td>");
		htmlDoc.append("<td>");
		htmlDoc.append("<div class=\"wrap\">");
		htmlDoc.append("<div class=\"fleft\">");
		htmlDoc.append(original);
		htmlDoc.append("</div>");
		htmlDoc.append("</td>");
		htmlDoc.append("</tr>");
		htmlDoc.append("</table>");
		htmlDoc.append("</body>");
		return htmlDoc.toString();
	}
	
	public static String buildCommunitiesTable(List<Cluster> communities) {
		StringBuilder htmlDoc = new StringBuilder();
		/* BUILD HEADER */
		htmlDoc.append("<html>");
		htmlDoc.append("<head><title>" + COMMUNITIES + "</title></head>");
		/* BUILD BODY */
		htmlDoc.append("<body>");
		htmlDoc.append("<b><font color=\"royalblue\" size=\"5\" face=\"verdana\"><center>" + COMMUNITIES + "</center></font></b>");
		htmlDoc.append("<br/>");
		htmlDoc.append("<br/>");
		htmlDoc.append("<table style=\"width:100%\" border=\"1\">");
		/* Insert Table Headers */
		htmlDoc.append("<tr>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"4\" face=\"verdana\">COMMUNITIES</font></b></th>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"2\" face=\"verdana\">COMEDY</font></b></th>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"2\" face=\"verdana\">DRAMA</font></b></th>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"2\" face=\"verdana\">FAMILY</font></b></th>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"2\" face=\"verdana\">HORROR</font></b></th>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"2\" face=\"verdana\">OTHER</font></b></th>");
		htmlDoc.append("<th><b><font color=\"seagreen\" size=\"2\" face=\"verdana\">USERS</font></b></th>");
		htmlDoc.append("</tr>");
		/* Insert Table Rows*/ 
		for(Cluster cluster: communities) {
			htmlDoc.append("<tr>");
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append("C" + cluster.getCluster());
			htmlDoc.append("</td>");
			/* Append comedy class */
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(cluster.getComedyClass());
			htmlDoc.append("</td>");
			/* Append drama class */
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(cluster.getDramaClass());
			htmlDoc.append("</td>");
			/* Append family class */
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(cluster.getFamilyClass());
			htmlDoc.append("</td>");
			/* Append horror class */
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(cluster.getHorrorClass());
			htmlDoc.append("</td>");
			/* Append other class */
			htmlDoc.append("<td align=\"center\">");
			htmlDoc.append(cluster.getOtherClass());
			htmlDoc.append("</td>");
			htmlDoc.append("<td align=\"center\">");
			
			/* Append clusters users, optimism, and reliability */
			for(UserCluster user: findUserCluster(cluster.getCluster()))
				htmlDoc.append(user.getName() + ", ");
			htmlDoc.append("</td>");
			htmlDoc.append("</tr>");
		}
		htmlDoc.append("</table>");
		htmlDoc.append("</body>");
		return htmlDoc.toString();
	}
	
	public static List<UserCluster> findUserCluster(Integer cluster){
		List<UserCluster> userClusters = new ArrayList<>();
		for (UserCluster userCluster : CSV.readUserCluster())
			if (userCluster.getCluster() == cluster)
				userClusters.add(userCluster);
		return userClusters;
	}
	
	/**
	 * Builds an HTML String representing a failure page.
	 * @param message error message to be shown to user
	 * @return HTML page as a String
	 */
	public static String buildFailure(String errorMessage) {
		StringBuilder response = new StringBuilder();
		response.append("<html>");
		response.append("<head><title>ERROR</title></head>");
		response.append("<body><b><font color=\"red\" size=\"6\" face=\"verdana\">" + errorMessage + "</font></b></body>");
		return response.toString();
	}

}
