package edu.carleton.comp4601.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cluster {
	private Integer cluster				= -1;
	private Integer comedyClass			= null;
	private Integer dramaClass			= null;
	private Integer familyClass			= null;
	private Integer horrorClass			= null;
	private Integer otherClass			= null;

	public Integer getCluster() 									{	return this.cluster; 							}
	public Integer getComedyClass() 								{	return this.comedyClass; 						}
	public Integer getDramaClass() 									{	return this.dramaClass; 						}
	public Integer getFamilyClass() 								{	return this.familyClass; 						}
	public Integer getHorrorClass() 								{	return this.horrorClass; 						}
	public Integer getOtherClass() 									{	return this.otherClass; 						}
	public void setCluster(Integer cluster) 						{	this.cluster 			= cluster; 				}
	public void setComedyClass(Integer comedyClass) 				{	this.comedyClass 		= comedyClass; 			}
	public void setDramaClass(Integer dramaClass) 					{	this.dramaClass 		= dramaClass; 			}
	public void setFamilyClass(Integer familyClass) 				{	this.familyClass		= familyClass; 			}
	public void setHorrorClass(Integer horrorClass) 				{	this.horrorClass 		= horrorClass; 			}
	public void setOtherClass(Integer otherClass)					{	this.otherClass 		= otherClass; 			}
	
	public String convertToCSV(){
		return String.format("%d,%d,%d,%d,%d,%d\n", cluster, comedyClass, dramaClass, familyClass, horrorClass, otherClass);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Cluster: " + this.getCluster() + ";\n");
		if (comedyClass != null)
			result.append(String.format("Comedy Class: %s\n", 	this.getComedyClass()));
		if (dramaClass != null)
			result.append(String.format("Drama Class: %s\n", 	this.getDramaClass()));
		if (familyClass != null)
			result.append(String.format("Family Class: %s\n", 	this.getFamilyClass()));
		if (horrorClass != null)
			result.append(String.format("Horror Class: %s\n", 	this.getHorrorClass()));
		if (otherClass != null)
			result.append(String.format("Other Class: %s\n", 	this.getOtherClass()));
		return result.toString();
	}
	
}
