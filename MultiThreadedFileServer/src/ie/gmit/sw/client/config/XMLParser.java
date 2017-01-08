package ie.gmit.sw.client.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLParser {
	private Parsetor p;

	public XMLParser(Parsetor p) {
		super();
		this.p = p;
	}
	
	public void init() throws Throwable{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Parsetor.CONF);
		
		Element root = doc.getDocumentElement(); //Get the root of the node tree
		NodeList children = root.getChildNodes(); //Get the child node of the root
	
		for (int i = 0; i < children.getLength(); i++){ //Loop over the child nodes
			Node next = children.item(i); //Get the next child
			
			if (next instanceof Element){ //Check if it is an element node. There are 12 different types of Node
				Element e = (Element) next; //Cast the general node to an element node
				
				if (e.getNodeName().equals("client-config")){ //Check if it is the element <client-config>
					NamedNodeMap atts = e.getAttributes(); //Get the attributes as a map of name/value pairs
					
					for (int j = 0; j < atts.getLength(); j++){ //Look over the attributes. This is similar to looping over a ket set in a Map
						if (atts.item(j).getNodeName().equals("username")){ // 
							p.setUsername(atts.item(j).getNodeValue()); //Update the p object
						}
					}
					
				}
				else if (e.getNodeName().equals("server-host"))
					p.setHost(e.getFirstChild().getNodeValue());
				
				else if (e.getNodeName().equals("server-port"))
					p.setPort(Integer.parseInt(e.getFirstChild().getNodeValue()));

				else if (e.getNodeName().equals("download-dir"))
					p.setDir(e.getFirstChild().getNodeValue());						
			}
		}		
		
	} // end init()

	// Getters & Setters
	public Parsetor getP() {
		return p;
	}

	public void setP(Parsetor p) {
		this.p = p;
	}
	
}
