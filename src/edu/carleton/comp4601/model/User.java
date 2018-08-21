package edu.carleton.comp4601.model;

import javax.xml.bind.annotation.XmlRootElement;

/*
* TODO: 4. Given the user profiles, you are to create 3 or more categories of user. 
* This is the value of m referenced in (9) and (12).
*/
@XmlRootElement
public class User {
	private String name			= null;
	private Double comedy		= 0d;
	private Double drama		= 0d;
	private Double family		= 0d;
	private Double horror		= 0d;
	private Double other		= 0d;
		
	public String getName() 						{	return this.name; 					}
	public Double getComedy() 						{	return this.comedy; 				}
	public Double getDrama() 						{	return this.drama; 					}
	public Double getFamily() 						{	return this.family; 				}
	public Double getHorror() 						{	return this.horror; 				}
	public Double getOther() 						{	return this.other; 					}
	public void setName(String name) 				{	this.name = name; 					}
	public void setComedy(Double comedy) 			{	this.comedy = comedy; 				}
	public void setDrama(Double drama) 				{	this.drama = drama; 				}
	public void setFamily(Double family) 			{	this.family = family; 				}
	public void setHorror(Double horror) 			{	this.horror = horror; 				}
	public void setOther(Double other) 				{	this.other = other; 				}

	public String convertToCSV(){
		return String.format("%s,%f,%f,%f,%f,%f\n", name, comedy, drama, family, horror, other);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("User: " 			+ this.getName() + "; ");
		result.append("Comedy: " 		+ this.getComedy() + ";");
		result.append("Drama: " 		+ this.getDrama() + ";");
		result.append("Family: " 		+ this.getFamily() + ";");
		result.append("Horror: " 		+ this.getHorror() + ";");
		result.append("Other: " 		+ this.getOther() + ";");
		return result.toString();
	}
	
}
