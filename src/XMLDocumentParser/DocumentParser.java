package XMLDocumentParser;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DocumentParser {
   public static void main(String[] args){
	   
	  // code from http://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
      try {	
         File inputFile = new File("September.xml");
         
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
   }
}
