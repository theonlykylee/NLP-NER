package DAO;

import java.util.ArrayList;

public class NewsDAO {
	String author;
	String title;
	String body;
	String date;
	
	ArrayList<String> personNamedEntities = new ArrayList<String>();
	ArrayList<String> locationNamedEntities = new ArrayList<String>();
	ArrayList<String> dateNamedEntities = new ArrayList<String>();
	
	public NewsDAO() {
		
	}
	
	public NewsDAO(String author, String title, String body, String date) {
		this.author = author;
		this.title = title;
		this.body = body;
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<String> getPersonNamedEntities() {
		return personNamedEntities;
	}

	public void setPersonNamedEntities(ArrayList<String> personNamedEntities) {
		this.personNamedEntities = personNamedEntities;
	}

	public ArrayList<String> getLocationNamedEntities() {
		return locationNamedEntities;
	}

	public void setLocationNamedEntities(ArrayList<String> locationNamedEntities) {
		this.locationNamedEntities = locationNamedEntities;
	}

	public ArrayList<String> getDateNamedEntities() {
		return dateNamedEntities;
	}

	public void setDateNamedEntities(ArrayList<String> dateNamedEntities) {
		this.dateNamedEntities = dateNamedEntities;
	}
	
	public void viewNewsAttributes() {
		System.out.println("[AUTHOR] : " + this.author);
		System.out.println("[TITLE] : " + this.title);
		System.out.println("[BODY] : " + this.body);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.print("[PERSON NAMED ENTITIES] : ");
		
		for(String p : this.personNamedEntities) {
			System.out.print("<" + p + ">  ");
		}
		
		System.out.print("\n[LOCATION NAMED ENTITIES] : ");
		
		for(String l : this.locationNamedEntities) {
			System.out.print("<" + l + ">  ");
		}
		
		System.out.print("[DATE NAMED ENTITIES] : ");
		
		for(String d : this.dateNamedEntities) {
			System.out.print("<" + d + ">  ");
		}
		
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
	
	
}
