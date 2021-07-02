/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * @author David Anderson
 * @created 2021
 */
package org.owasp.benchmark.helpers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** This class contains all the vulnerability categories currently defined. */
public class Categories {
    public static final String FILENAME = "categories.xml";

    private Map<String, Category> idToCategoryMap;
    private Map<String, Category> nameToCategoryMap;

    public Categories() {
        System.out.println(
                "ERROR: Categories cannot be constructed without supplying it a configuration file.");
        Exception e = new Exception();
        e.printStackTrace();
        System.exit(-1);
    }

    public Categories(File file) throws ParserConfigurationException, SAXException, IOException {
        load(file);
    }

    private void load(File file) throws ParserConfigurationException, SAXException, IOException {
        Map<String, Category> idToCategoryMap = new HashMap<String, Category>();
        Map<String, Category> nameToCategoryMap = new HashMap<String, Category>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // avoid attacks like XML External Entities (XXE)
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document = db.parse(file);
        document.getDocumentElement().normalize();

        // Here comes the root node
        Element root = document.getDocumentElement();

        // Get all categories
        NodeList nList = document.getElementsByTagName("category");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // Print each ecategory's detail
                Element eElement = (Element) node;
                String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                NodeList cweNodeList = eElement.getElementsByTagName("cwe");
                // Default value -- CWEs included in expected results file. Might be used during
                // scoring.
                int cwe = 0;
                if (cweNodeList.getLength() > 0) {
                    cwe = Integer.parseInt(cweNodeList.item(0).getTextContent());
                }
                NodeList isInjectionNodeList = eElement.getElementsByTagName("isInjection");
                boolean isInjection = false; // Default value
                if (isInjectionNodeList.getLength() > 0) {
                    isInjection =
                            Boolean.parseBoolean(isInjectionNodeList.item(0).getTextContent());
                }
                String shortname =
                        eElement.getElementsByTagName("shortname").item(0).getTextContent();
                Category category = new Category(id, name, cwe, isInjection, shortname);
                idToCategoryMap.put(id, category);
                nameToCategoryMap.put(name, category);
            }
        }

        this.idToCategoryMap = idToCategoryMap;
        this.nameToCategoryMap = nameToCategoryMap;
    }

    public Category getById(String id) {
        return idToCategoryMap.get(id);
    }

    public Category getByName(String name) {
        return nameToCategoryMap.get(name);
    }
}
