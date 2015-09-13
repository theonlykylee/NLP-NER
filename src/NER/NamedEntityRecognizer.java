package NER;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String newsBody;
		
		for(NewsDAO nd : nDAO) {
			newsBody = nd.getBody();
			
			nd.setPersonNamedEntities(extractPersons(newsBody));
			nd.setLocationNamedEntities(extractLocations(newsBody));
			nd.setDateNamedEntities(extractDates(newsBody));
		}
	}
	
	public ArrayList<String> extractPersons(String largeText) {
		ArrayList<String> extractedPersons = new ArrayList<String>();
		ArrayList<String> personRegex = new ArrayList<String>();
		
		//add regex's to the list here
		// si <person's name - up to four words> 
		personRegex.add("((s|S)(i|I))(\\s)+([a-zA-Z\\-\\.\\\"]+(\\s)*){1,5}");
		// ni <person's name - up to four words> 
		personRegex.add("((n|N)(i|I))(\\s)+([a-zA-Z\\-\\.]+(\\s)*){1,3}");
		// nina/sina <person's name> at <person's name>
		personRegex.add("(((n|N)|(s|S))(i|I)(n|N)(a|A))(\\s)+((([a-zA-Z\\-]+(\\s)*)");
		
		for(String pRegex : personRegex) {
			ArrayList<String> temp = matchPatterns(pRegex, largeText);
			extractedPersons.addAll(temp);
		}
		
		return extractedPersons;
	}
	
	public ArrayList<String> extractLocations(String largeText) {
		ArrayList<String> extractedLocations = new ArrayList<String>();
		ArrayList<String> locationRegex = new ArrayList<String>();
		
		//add regex's to the list here
		
		for(String lRegex : locationRegex) {
			ArrayList<String> temp = matchPatterns(lRegex, largeText);
			extractedLocations.addAll(temp);
		}
		
		return extractedLocations;
	}
	
	public ArrayList<String> extractDates(String largeText) {
		ArrayList<String> extractedDates = new ArrayList<String>();
		ArrayList<String> dateRegex = new ArrayList<String>();
		
		//add regex's to the list here
		// September, 9 2015
		// September 9, 2015
		// September 9
		// Sept. 9 2015
		// Sept. 9, 2015
		dateRegex.add("[a-zA-Z]+[\\,\\.]*[\\s]*[0-9]+[\\s\\.\\,]*[0-9]*");
		// 9/9/2015
		// 9/9
		dateRegex.add("[0-9]+[\\/]+[0-9]+[\\/]*[0-9]*");
		
		for(String dRegex : dateRegex) {
			ArrayList<String> temp = matchPatterns(dRegex, largeText);
			extractedDates.addAll(temp);
		}
		
		return extractedDates;
	}
     
    public ArrayList<String> matchPatterns(String pattern, String largeText) {
		Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(largeText);
        ArrayList<String> stringMatches = new ArrayList<String>();
        
        while(match.find()){
        	stringMatches.add(match.group());
        }
        
        return stringMatches;
    }
}
