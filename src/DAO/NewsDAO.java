package DAO;

import java.util.ArrayList;

public class NewsDAO {
	String author;
	String title;
	String body;
	String date;
	
	ArrayList<String> namedEntities = new ArrayList<String>();
	
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

	public ArrayList<String> getNamedEntities() {
		return namedEntities;
	}

	public void setNamedEntities(ArrayList<String> namedEntities) {
		this.namedEntities = namedEntities;
	}
	
	

}
