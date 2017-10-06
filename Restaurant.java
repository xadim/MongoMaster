package mongo.products;

import com.mongodb.DBCollection;

/*
 * 
 * 
 * 
 * *
 * 
 */
public class Restaurant {

	private int rest_id;
	public String rest_Name;
	public String grades;
	public String address;
	public String borough;
	
	public int getRest_id() {
		return rest_id;
	}
	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}
	public String getRest_Name() {
		return rest_Name;
	}
	public void setRest_Name(String rest_Name) {
		this.rest_Name = rest_Name;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String borough) {
		this.borough = borough;
	}
	
}
