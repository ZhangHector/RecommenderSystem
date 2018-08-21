package edu.carleton.comp4601.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Configuration {

	public static final String DATABASE_DIR 		= "/Users/Hun/Documents/Eclipse/Workspace/COMP4601-RS/resource/";
	public static final String CONFIGURATION_FILE 	= "configuration.txt";
	public static final String CONTEXT_INITIALIZED 	= "Context Initialized";
	public static final String CONTEXT_COMPUTING		= "Context Computing";
	public static final String DATA_MIGRATED		= "Data Migrated";
	
	public static void write(String configuration){
		try {
			String history = String.format("%s\n", read());
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DATABASE_DIR + CONFIGURATION_FILE), "utf-8"));
			writer.write(history+configuration);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String read(){
		String result = "";
        String line = "";
        try {
			if (!new File(DATABASE_DIR + CONFIGURATION_FILE).exists()){
				new File(DATABASE_DIR + CONFIGURATION_FILE).createNewFile();
			}
        	BufferedReader br = new BufferedReader(new FileReader(DATABASE_DIR + CONFIGURATION_FILE));
            while ((line = br.readLine()) != null) 
                result += line;
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
	}
	
	public static void reset(){
		new File(DATABASE_DIR + CONFIGURATION_FILE).delete();
	}
	
}
