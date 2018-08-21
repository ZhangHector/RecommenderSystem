package edu.carleton.comp4601.model;

/**
 * TODO: 6. In order to achieve (5) you must:
 * 		1. Design a model for user preferences based upon the content of the web pages.
 * 		2. Determine communities for users.
 * 		3. Create advertising content that reflects the interests of the users in that community.
 * 		4. Design and implement a mechanism for associating appropriate advertising given a user and a page request.
 * */
public class Advertisement {
	private String title				= null;
	private String caption				= null;
	private String visual				= null;
	private Integer comedyClass			= null;
	private Integer dramaClass			= null;
	private Integer familyClass			= null;
	private Integer horrorClass			= null;
	private Integer otherClass			= null;
	
	public void setTitle(String title) 							{	this.title 				= title; 				}
	public void setCaption(String caption) 						{	this.caption 			= caption; 				}
	public void setVisual(String visual) 						{	this.visual 			= visual; 				}
	public void setComedyClass(Integer comedyClass) 			{	this.comedyClass 		= comedyClass; 			}
	public void setDramaClass(Integer dramaClass) 				{	this.dramaClass 		= dramaClass; 			}
	public void setFamilyClass(Integer familyClass) 			{	this.familyClass		= familyClass; 			}
	public void setHorrorClass(Integer horrorClass) 			{	this.horrorClass 		= horrorClass; 			}
	public void setOtherClass(Integer otherClass)				{	this.otherClass 		= otherClass; 			}
	public String getTitle() 									{	return this.title;								}
	public String getCaption() 									{	return this.caption; 							}
	public String getVisual() 									{	return this.visual; 							}
	public Integer getComedyClass() 							{	return this.comedyClass; 						}
	public Integer getDramaClass() 								{	return this.dramaClass; 						}
	public Integer getFamilyClass() 							{	return this.familyClass; 						}
	public Integer getHorrorClass() 							{	return this.horrorClass; 						}
	public Integer getOtherClass() 								{	return this.otherClass; 						}

	public String convertToCSV(){
		return String.format("%s,%s,%s,%d,%d,%d,%d,%d\n", title, caption, visual, comedyClass, dramaClass, familyClass, horrorClass, otherClass);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("\nAd: %s\n", 			this.getTitle()));
		result.append(String.format("Caption: %s\n", 		this.getCaption()));
		result.append(String.format("Visual: %s\n", 		this.getVisual()));
		result.append(String.format("Comedy Class: %s\n", 	this.getComedyClass()));
		result.append(String.format("Drama Class: %s\n", 	this.getDramaClass()));
		result.append(String.format("Family Class: %s\n", 	this.getFamilyClass()));
		result.append(String.format("Horror Class: %s\n", 	this.getHorrorClass()));
		result.append(String.format("Other Class: %s\n", 	this.getOtherClass()));
		return result.toString();
	}
	
}
