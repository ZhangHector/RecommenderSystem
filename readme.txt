Student Name:	Rui Li & Hector Zhang
Student Number:	100987686 & 100947935
Professor Name:	Tony White
Due Date:	Apri 2, 2018
Course Name:	COMP 4601

Testing Environment:
	OS:	Max OSX
	IDE:	Eclipse Neon
	Library:
		Java 1.8
		Apache Tomcat 7.0
		JSoup 1.0.2
		Jersey 1.19

Root directory for the project is located at CSV.java in the package of edu.carleton.comp4601.utils.
	DATABASE_DIR:	"/Users/Hun/Documents/Eclipse/Workspace/COMP4601-RS/resource/";

To run the application:
	- Open the application in eclipse
	- Make sure dataset directory is located under project root directory
	- All testing dataset should be in project root as well.
	- run recommend.java in the package of edu.com.carleton.com4601.resource

To test the RESTFul service, run the following api in any browser:
	- main: 	http://localhost:8080/COMP4601-RS/rest/rs
	- context;	http://localhost:8080/COMP4601-RS/rest/re/context
	- community:	http://localhost:8080/COMP4601-RS/rest/re/community
	- advertising:	http://localhost:8080/COMP4601-RS/rest/re/advertising/{community}
	- fetch:	http://localhost:8080/COMP4601-RS/rest/re/fetch/{user}/{page}
	- reset:	http://localhost:8080/COMP4601-RS/rest/re/reset/{dir}
	* community should be in range 1, 2, 3, 4, 5 (Due to K-Mean Algorithm)
	* dir should be in the project root
	* make sure subfolders for pages, users, reviews are also included.
	

	
