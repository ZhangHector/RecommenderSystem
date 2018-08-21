package edu.carleton.comp4601.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserCluster {
	private String name		= null;
	private Integer cluster = -1;
		
	public String getName() 					{	return this.name; 			}
	public Integer getCluster()					{	return this.cluster; 		}
	public void setName(String name) 			{	this.name = name;			}
	public void setCluster(Integer cluster)		{	this.cluster = cluster;		}

	public String convetToCSV(){
		return String.format("%s,%d\n", name, cluster);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("User: " + this.getName() + "; ");
		result.append("Cluster: " + this.getCluster() + "; ");
		return result.toString();
	}

}
