package NER;

import java.util.ArrayList;

import DAO.NewsDAO;

public class NamedEntityRecognizer {
	ArrayList<NewsDAO> nDAO = new ArrayList<NewsDAO>();
	
	
	public NamedEntityRecognizer() {
		
	}


	public ArrayList<NewsDAO> getnDAO() {
		return nDAO;
	}


	public void setnDAO(ArrayList<NewsDAO> nDAO) {
		this.nDAO = nDAO;
	}
	
	public void extractNamedEntities() {
		//do the magic here haha
		String newsBody;
		
		for(NewsDAO nd : nDAO) {
			newsBody = nd.getBody();
			
			//do the magic here :))
		}
	}
	
	

}
