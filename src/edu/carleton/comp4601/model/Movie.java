package edu.carleton.comp4601.model;

public class Movie {
	private String name;
	private String genre;
	
	public String getName() 				{	return name;			}
	public String getGenre() 				{	return genre;			}
	public void setName(String name) 		{	this.name 	= name;		}
	public void setGenre(String genre) 		{	this.genre 	= genre;	}

	public String convertToCSV(){
		return String.format("%s, %d\n", name, genre);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Movie: " + this.getName() + "; ");
		result.append("Genre: " + this.getGenre() + ";");
		return result.toString();
	}

}
