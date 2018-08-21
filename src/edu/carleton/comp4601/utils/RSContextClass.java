package edu.carleton.comp4601.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.carleton.comp4601.migration.DatabaseMigration;

/**
 * This listens for the web application starting and closing.
 * @author Hector Zhang & Rui Li
 */

public class RSContextClass implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) { System.out.println("CLOSING RS APP..."); }
	
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("INITIALIING RS APP...");
		if (Configuration.read().contains(Configuration.DATA_MIGRATED)){
			System.out.println("Local Database already exists! Migration is skipped.");
			return;
		}
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Creating new Configuration Setting...");
				System.out.println("Migrating data in the background...");
				System.out.println("Please wait for completion update...");
				DatabaseMigration.migrate();
				Configuration.write(Configuration.DATA_MIGRATED);
				System.out.println("Data has been migrated successfuly!");
			}
		}).start();
	}

}
