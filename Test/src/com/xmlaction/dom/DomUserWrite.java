package com.xmlaction.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomUserWrite {
	public static void main(String[] args) {
		// DOM����������DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// DOM��������DocumentBuilder
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		// xml����
		Document doc = builder.newDocument();
		Element list = doc.createElement("list");
		Element user = doc.createElement("User");
		Element name = doc.createElement("name");
		Element phone = doc.createElement("phone");
		Element address = doc.createElement("address");

		address.appendChild(doc.createTextNode("ABC"));
		phone.appendChild(doc.createTextNode("004"));
		name.appendChild(doc.createTextNode("Sun"));

		user.setAttribute("id", "04");

		user.appendChild(name);
		user.appendChild(phone);
		user.appendChild(address);
		list.appendChild(user);
		doc.appendChild(list);
		TransformerFactory transformerfactory = TransformerFactory
				.newInstance();
		Transformer transFormer = null;
		try {
			transFormer = transformerfactory.newTransformer();

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		transFormer.setOutputProperty(OutputKeys.ENCODING, "GBK");
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(
				new File("WebContent" + File.separator + "WEB-INF"
						+ File.separator + "User_outpout.xml"));
		try {
			transFormer.transform(domSource, streamResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
