import java.util.Scanner;

import DAO.NewsDAO;
import NER.NamedEntityRecognizer;
import XMLDocumentParser.DocumentParser;


public class NERDriver {
	NewsDAO nDAO;
	DocumentParser docParser;
	
	String filename;
	Scanner s;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		DocumentParser docParser = new DocumentParser();
		NamedEntityRecognizer ner = new NamedEntityRecognizer();
		Scanner s = new Scanner(System.in);
		String filename;
		
		System.out.println("===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===");
		System.out.println(":: NAMED ENTITY RECOGNIZER USING REGULAR EXPRESSIONS ::");
		System.out.print("   > Enter filename of News XML (exclude the extension): ");
		
		filename = s.next();
		filename += ".xml";
		
		System.out.println("===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===");
		
		docParser.parseXMLNewsFile(filename);
		//ner.setnDAO(docParser.parseXMLNewsFile(filename));
		//ner.extractNamedEntities();
		
		System.out.println("===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===");
		System.out.println(":: NEWS ATTRIBUTE VIEW ::");
		System.out.println("===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===");
		
		for(NewsDAO n : ner.getnDAO()) {
			n.viewNewsAttributes();
		}
	}

}
