package edu.carleton.comp4601.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.carleton.comp4601.clustering.KMeans;
import edu.carleton.comp4601.model.Advertisement;
import edu.carleton.comp4601.model.Cluster;

/**
 * @author Hector Zhang & Rui Li
 */
public class AdvertisementFactory {
	
	private static Map<String, Advertisement> ADVERTISEMENTS = new HashMap<>();
	
	static {
		Advertisement ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 0");
		ADVERTISEMENT.setCaption("For the Level of Comedy 0");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(0);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("00", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 1");
		ADVERTISEMENT.setCaption("For the level of Comedy 1");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(1);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("01", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 2");
		ADVERTISEMENT.setCaption("For the level of Comedy 2");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(2);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("02", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 3");
		ADVERTISEMENT.setCaption("For the level of Comedy 3");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(3);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("03", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 4");
		ADVERTISEMENT.setCaption("For the level of Comedy 4");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(4);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("04", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 5");
		ADVERTISEMENT.setCaption("For the level of Comedy 5");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(5);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("05", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 6");
		ADVERTISEMENT.setCaption("For the level of Comedy 6");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(6);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("06", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 7");
		ADVERTISEMENT.setCaption("For the level of Comedy 7");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(7);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("07", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 8");
		ADVERTISEMENT.setCaption("For the level of Comedy  8");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(8);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("08", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Comedy 9");
		ADVERTISEMENT.setCaption("For the level of Comedy 9");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/comedy-genre.jpg");
		ADVERTISEMENT.setComedyClass(9);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("09", ADVERTISEMENT);	
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 0");
		ADVERTISEMENT.setCaption("For the level of Drama 0");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(0);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("10", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 1");
		ADVERTISEMENT.setCaption("For the level of Drama 1");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(1);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("11", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 2");
		ADVERTISEMENT.setCaption("For the level of Drama 2");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(2);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("12", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 3");
		ADVERTISEMENT.setCaption("For the level of Drama 3");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(3);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("13", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 4");
		ADVERTISEMENT.setCaption("For the level of Drama 4");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(4);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("14", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 5");
		ADVERTISEMENT.setCaption("For the level of Drama 5");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(5);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("15", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 6");
		ADVERTISEMENT.setCaption("For the level of Drama 6");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(6);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("16", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 7");
		ADVERTISEMENT.setCaption("For the level of Drama 7");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(7);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("17", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 8");
		ADVERTISEMENT.setCaption("For the level of Drama 8");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(8);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("18", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Drama 9");
		ADVERTISEMENT.setCaption("For the level of Drama 9");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/drama-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(9);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("19", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 0");
		ADVERTISEMENT.setCaption("For the level of Family 0");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(0);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("20", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 1");
		ADVERTISEMENT.setCaption("For the level of Family 1");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(1);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("21", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 2");
		ADVERTISEMENT.setCaption("For the level of Family 2");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(2);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("22", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 3");
		ADVERTISEMENT.setCaption("For the level of Family 3");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(3);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("23", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 4");
		ADVERTISEMENT.setCaption("For the level of Family 4");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(4);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("24", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 5");
		ADVERTISEMENT.setCaption("For the level of Family 5");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(5);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("25", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 6");
		ADVERTISEMENT.setCaption("For the level of Family 6");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(6);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("26", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 7");
		ADVERTISEMENT.setCaption("For the level of Family 7");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(7);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("27", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 8");
		ADVERTISEMENT.setCaption("For the level of Family 8");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(8);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("28", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Family 9");
		ADVERTISEMENT.setCaption("For the level of Family 9");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/childrens-family-genre2.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(9);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("29", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 0");
		ADVERTISEMENT.setCaption("For the level of Horror 0");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(0);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("30", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 1");
		ADVERTISEMENT.setCaption("For the level of Horror 1");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(1);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("31", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 2");
		ADVERTISEMENT.setCaption("For the level of Horror 2");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(2);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("32", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 3");
		ADVERTISEMENT.setCaption("For the level of Horror 3");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(3);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("33", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 4");
		ADVERTISEMENT.setCaption("For the level of Horror ");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(4);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("34", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 5");
		ADVERTISEMENT.setCaption("For the level of Horror 5");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(5);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("35", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 6");
		ADVERTISEMENT.setCaption("For the level of Horror 6");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(6);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("36", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 7");
		ADVERTISEMENT.setCaption("For the level of Horror 7");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(7);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("37", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 8");
		ADVERTISEMENT.setCaption("For the level of Horror 8");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(8);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("38", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Horror 9");
		ADVERTISEMENT.setCaption("For the level of Horror 9");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/horror-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(9);
		ADVERTISEMENT.setOtherClass(null);
		ADVERTISEMENTS.put("39", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 0");
		ADVERTISEMENT.setCaption("For the level of Other 0");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(0);
		ADVERTISEMENTS.put("40", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 1");
		ADVERTISEMENT.setCaption("For the level of Other 1");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(1);
		ADVERTISEMENTS.put("41", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 2");
		ADVERTISEMENT.setCaption("For the level of Other 2");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(2);
		ADVERTISEMENTS.put("42", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 3");
		ADVERTISEMENT.setCaption("For the level of Other 3");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(3);
		ADVERTISEMENTS.put("43", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 4");
		ADVERTISEMENT.setCaption("For the level of Other 4");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(4);
		ADVERTISEMENTS.put("44", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 5");
		ADVERTISEMENT.setCaption("For the level of Other 5");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(5);
		ADVERTISEMENTS.put("45", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 6");
		ADVERTISEMENT.setCaption("For the level of Other 6");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(6);
		ADVERTISEMENTS.put("46", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 7");
		ADVERTISEMENT.setCaption("For the level of Other 7");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(7);
		ADVERTISEMENTS.put("47", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 8");
		ADVERTISEMENT.setCaption("For the level of Other 8");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(8);
		ADVERTISEMENTS.put("48", ADVERTISEMENT);
		
		ADVERTISEMENT = new Advertisement();
		ADVERTISEMENT.setTitle("Other 9");
		ADVERTISEMENT.setCaption("For the level of Other 9");
		ADVERTISEMENT.setVisual("http://www.filmsite.org/images/classicfilms-genre.jpg");
		ADVERTISEMENT.setComedyClass(null);
		ADVERTISEMENT.setDramaClass(null);
		ADVERTISEMENT.setFamilyClass(null);
		ADVERTISEMENT.setHorrorClass(null);
		ADVERTISEMENT.setOtherClass(9);
		ADVERTISEMENTS.put("49", ADVERTISEMENT);
	}
	
	public static void createAds() {
		System.out.println("x----------------------x");
		System.out.println("CREATING ADS...");
		System.out.println();
		/* Add to Local Database */
		System.out.println("Adding to Local Database...");
		System.out.println("Please be patient...");

		StringBuilder sb = new StringBuilder();
		sb.append(CSV.ADVERTISEMENT_HEADING);
		for (int i = 0; i < KMeans.NUM_CLUSTERS; i++){
			for (int j = 0; j < 10; j++){
				sb.append(ADVERTISEMENTS.get(String.format("%d%d", i, j)).convertToCSV());
			}
		}
		CSV.writeAdvertisement(sb.toString());
		
		System.out.println();
		System.out.println("AD CREATION COMPLETE!");
		System.out.println("x----------------------x");
	}

	public static List<Advertisement> findByCommunity(int community){
		List<Advertisement> advertisements = new ArrayList<>();
		List<Cluster> clusters = CSV.readCluster();
		advertisements.add(ADVERTISEMENTS.get(String.format("%d%d", 0, clusters.get(community).getComedyClass())));
		advertisements.add(ADVERTISEMENTS.get(String.format("%d%d", 1, clusters.get(community).getDramaClass())));
		advertisements.add(ADVERTISEMENTS.get(String.format("%d%d", 2, clusters.get(community).getFamilyClass())));
		advertisements.add(ADVERTISEMENTS.get(String.format("%d%d", 3, clusters.get(community).getHorrorClass())));
		advertisements.add(ADVERTISEMENTS.get(String.format("%d%d", 4, clusters.get(community).getOtherClass())));
		return advertisements;
	}
	
	public static Advertisement findByCommunityAndGenre(int community, String genre){
		List<Advertisement> advertisements = findByCommunity(community);
		if (genre.equals("comedy"))
			return advertisements.get(0);
		if (genre.equals("drama"))
			return advertisements.get(1);
		if (genre.equals("family"))
			return advertisements.get(2);
		if (genre.equals("horror"))
			return advertisements.get(3);
		if (genre.equals("other"))
			return advertisements.get(4);
		return null;
	}
	
	public static List<Advertisement> findByCluster(Cluster cluster){
		List<Advertisement> advertisements = new ArrayList<>();
		List<Advertisement> allAdvs = CSV.readAdvertisement();
		/* Get all comedy ads */
		advertisements.add(allAdvs.get(cluster.getComedyClass()));
		/* Get all drama ads */
		advertisements.add(allAdvs.get(10+cluster.getDramaClass()));
		/* Get all drama ads */
		advertisements.add(allAdvs.get(20+cluster.getFamilyClass()));
		/* Get all drama ads */
		advertisements.add(allAdvs.get(30+cluster.getHorrorClass()));
		/* Get all other ads */
		advertisements.add(allAdvs.get(40+cluster.getOtherClass()));
		return advertisements;
	}
	
	public static List<Advertisement> findComedyClass(){
		List<Advertisement> advertisements = new ArrayList<>();
		for (Advertisement adv : CSV.readAdvertisement())
			if (adv.getComedyClass() != null)
				advertisements.add(adv);
		return advertisements;
	}
	
	public static List<Advertisement> findDramaClass(){
		List<Advertisement> advertisements = new ArrayList<>();
		for (Advertisement adv : CSV.readAdvertisement())
			if (adv.getDramaClass() != null)
				advertisements.add(adv);
		return advertisements;
	}
	
	public static List<Advertisement> findFamilyClass(){
		List<Advertisement> advertisements = new ArrayList<>();
		for (Advertisement adv : CSV.readAdvertisement())
			if (adv.getFamilyClass() != null)
				advertisements.add(adv);
		return advertisements;
	}
	
	public static List<Advertisement> findHorrorClass(){
		List<Advertisement> advertisements = new ArrayList<>();
		for (Advertisement adv : CSV.readAdvertisement())
			if (adv.getHorrorClass() != null)
				advertisements.add(adv);
		return advertisements;
	}
	
	public static List<Advertisement> findOtherClass(){
		List<Advertisement> advertisements = new ArrayList<>();
		for (Advertisement adv : CSV.readAdvertisement())
			if (adv.getOtherClass() != null)
				advertisements.add(adv);
		return advertisements;
	}
	
}
