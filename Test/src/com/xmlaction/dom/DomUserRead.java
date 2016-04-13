package com.xmlaction.dom;

import com.object.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomUserRead {

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
		Document doc = null;
		try {
// �̶�·����ȡ
			doc = builder.parse("WebContent" + File.separator + "WEB-INF"
					+ File.separator + "User.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
// getDocumentElement()��DOM��������ȡxml���ڵ�
		NodeList nodelist = doc.getDocumentElement()
				.getElementsByTagName("User");
		User user = new User();
		Map<Integer, User> usermap = new HashMap<Integer, User>();
		for (int i = 0; i < nodelist.getLength(); i++) {
// getFirstChild().getNodeValue()��DOM���ı���Ҳ��Ϊ��һ���ڵ�
			user.setId(Integer
					.parseInt(((Element) nodelist.item(i)).getAttribute("id")));
			user.setName(
					((Element) nodelist.item(i)).getElementsByTagName("name")
							.item(0).getFirstChild().getNodeValue());
			user.setPhone(
					((Element) nodelist.item(i)).getElementsByTagName("phone")
							.item(0).getFirstChild().getNodeValue());
			user.setAddress(
					((Element) nodelist.item(i)).getElementsByTagName("address")
							.item(0).getFirstChild().getNodeValue());
			usermap.put(user.getId(), user);

			/**
			 * print for test
			 */
			for (Integer key : usermap.keySet()) {

				System.out.println("UserID= " + key);
				System.out.println("Name= " + usermap.get(key).getName());
				System.out.println("Phone= " + usermap.get(key).getPhone());
				System.out.println("Address= " + usermap.get(key).getAddress());
			}

		}

	}

}
