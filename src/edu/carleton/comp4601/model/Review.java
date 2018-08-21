package edu.carleton.comp4601.model;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * TODO: 1. You are given >1000 web pages which are hyperlinked. 
 * These are stored in the web pages directory. 
 * The web pages contain text. 
 * The text is "real".
 * */
@XmlRootElement
public class Review {
	private int id 				= 0;
	private String userName		= null;
	private String movieName	= null;
	private Double score		= null;
	private Double helpfulness	= null;
	private String genre		= null;
		
	public int getId() 								{ 	return this.id; 					}
	public String getUserName() 					{ 	return this.userName; 				}
	public String getMovieName() 					{ 	return this.movieName; 				}
	public Double getScore() 						{ 	return this.score; 					}
	public Double getHelpfulness() 					{ 	return this.helpfulness; 			}
	public String getGenre()						{	return this.genre;					}
	public void setId(int id) 						{	this.id 			= id; 			}
	public void setUserName(String userName) 		{ 	this.userName 		= userName; 	}
	public void setMovieName(String movieName) 		{ 	this.movieName 		= movieName; 	}
	public void setScore(Double score) 				{	this.score 			= score; 		}
	public void setHelpfulness(Double helpfulness)	{	this.helpfulness 	= helpfulness; 	}
	public void setGenre(String genre)				{	this.genre			= genre;		}
	
	public String convertToCSV(){
		return String.format("%d,%s,%s,%f,%f,%s\n", id, userName, movieName, score, helpfulness, genre);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Review: " + 
				this.getId() + "-" +
				this.getMovieName() +  "-" + 
				this.getUserName() + "; ");
		result.append(String.format("Score: 		%.4f; ", this.getScore()));
		result.append(String.format("Helpfulness: 	%.4f; ", this.getHelpfulness()));
		result.append(String.format("Genre: 		%.4f; ", this.genre));
		return result.toString();
	}

}
