package XMLDocumentParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import DAO.NewsDAO;

public class DocumentParser {
	ArrayList<NewsDAO> newsList;
	String xmlFileName;
	
	public DocumentParser() {
		
	}
	
	public ArrayList<NewsDAO> parseXMLNewsFile(String xmlfilename) {
		newsList = new ArrayList<NewsDAO>();
		
		// code from http://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
		try {	
			File inputFile = new File(xmlfilename);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("article");

			System.out.println(":: XML DOCUMENT PARSER FOR NEWS ARTICLES ::");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String au = eElement.getElementsByTagName("author").item(0).getTextContent();
					String ti = eElement.getElementsByTagName("title").item(0).getTextContent();
					String bo = eElement.getElementsByTagName("body").item(0).getTextContent();
					String da = eElement.getElementsByTagName("month").item(0).getTextContent() + " " 
							+ eElement.getElementsByTagName("day").item(0).getTextContent() + ", "
							+ eElement.getElementsByTagName("year").item(0).getTextContent();
					
					NewsDAO n = new NewsDAO(au, ti, bo, da);
					newsList.add(n);

					System.out.println("   > Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
					System.out.println("   > Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("   > Body : " + eElement.getElementsByTagName("body").item(0).getTextContent());
					System.out.println("   > Date : " + eElement.getElementsByTagName("month").item(0).getTextContent() + " " 
							+ eElement.getElementsByTagName("day").item(0).getTextContent() + ", "
							+ eElement.getElementsByTagName("year").item(0).getTextContent());
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				}
			}

			System.out.println(":: XML Parsing Successful: " + nList.getLength() + " entries parsed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newsList;
	}
	
	public void saveXML(List<NewsDAO> daos){
		
		// initialize the document
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			
			// root node
			Document doc = docBuilder.newDocument();
			Element rootNode = doc.createElement("entities");
			doc.appendChild(rootNode);
			
			// Date Entities
			Element dateNode = doc.createElement("dates");
			Element personNode = doc.createElement("persons");
			Element locationNode = doc.createElement("locations");
			for(NewsDAO dao: daos)
			{
				for(String date: dao.getDateNamedEntities())
				{
					Element entity = doc.createElement("date");
					entity.appendChild(doc.createTextNode(date));
					dateNode.appendChild(entity);
				}
					

				for(String person: dao.getPersonNamedEntities())
				{
					Element personEntity = doc.createElement("person");
					personEntity.appendChild(doc.createTextNode(person));
					personNode.appendChild(personEntity);
				}
				
				for(String location: dao.getLocationNamedEntities())
				{
					Element locationEntity = doc.createElement("location");
					locationEntity.appendChild(doc.createTextNode(location));
					locationNode.appendChild(locationEntity);
				}
				
				
			}
			
			rootNode.appendChild(dateNode);
			rootNode.appendChild(personNode);
			rootNode.appendChild(locationNode);
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./result.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (TransformerException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
}
