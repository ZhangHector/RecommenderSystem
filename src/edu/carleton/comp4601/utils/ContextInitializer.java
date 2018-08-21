package edu.carleton.comp4601.utils;

import edu.carleton.comp4601.classification.Classifier;
import edu.carleton.comp4601.clustering.Clustering;
import edu.carleton.comp4601.computer.FeatureComputation;

/**
 * @author Hector Zhang & Rui Li
 */
public class ContextInitializer {
	
	public static void initialize() {
		System.out.println("Initializing Context...");
		System.out.println("PHASE 1: Compute User Features.");
		FeatureComputation.computeUserFeatures();
		System.out.println("PHASE 2: Create Clusters.");
		Clustering.execute();
		System.out.println("PHASE 3: Classify Clusters.");
		Classifier.classify();
		System.out.println("PHASE 4: Insert Advertisements.");
		AdvertisementFactory.createAds();
		Configuration.write(Configuration.CONTEXT_INITIALIZED);
		System.out.println("Updating Local Database flag...");
		System.out.println("Context Initialized!");
	}
	
}
