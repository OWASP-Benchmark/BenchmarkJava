package org.owasp.benchmark.tools;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLCrawler {
	public static Node getNamedNode(String name, NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			if (n.getNodeName().equals(name)) {
				return n;
			}
		}
		return null;
	}

	public static Node getNamedChild(String name, Node parent) {
		NodeList children = parent.getChildNodes();
		return getNamedNode(name, children);
	}

	public static List<Node> getNamedChildren(String name, List<Node> list) {
		List<Node> results = new ArrayList<Node>();
		for (Node n : list) {
			NodeList children = n.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if (child.getNodeName().equals(name)) {
					System.out.println("> " + child.getNodeName() + "::" + child.getNodeValue());
					results.add(child);
				}
			}
		}
		return results;
	}

	public static List<Node> getNamedChildren(String name, Node parent) {
		NodeList children = parent.getChildNodes();
		return getNamedNodes(name, children);
	}

	public static List<Node> getNamedNodes(String name, NodeList list) {
		List<Node> results = new ArrayList<Node>();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			if (n.getNodeName().equals(name)) {
				// System.out.println(">> " + n.getNodeName() + "::" +
				// n.getNodeValue());
				results.add(n);
			}
		}
		return results;
	}

	public static String getAttributeValue(String name, Node node) {
		if (node == null) {
			return null;
		}
		NamedNodeMap nnm = node.getAttributes();
		if (nnm != null) {
			Node attrnode = nnm.getNamedItem(name);
			if (attrnode != null) {
				String value = attrnode.getNodeValue();
				if (value.equals("[random]")) {
					value = getToken();
				}
				return value;
			}
		}
		return null;
	}

	private static SecureRandom sr = new SecureRandom();

	private static String getToken() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append((char) (sr.nextInt(26) + 'a'));
		}
		for (int i = 0; i < 3; i++) {
			sb.append((char) (sr.nextInt(10) + '0'));
		}
		return sb.toString();
	}
}
