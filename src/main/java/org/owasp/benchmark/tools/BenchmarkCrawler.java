/**
 * OWASP Benchmark Project
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
 *
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
 * @created 2016
 */

package org.owasp.benchmark.tools;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class BenchmarkCrawler {

    private static String url = "https://localhost:8443/benchmark/BenchmarkTest";
    
    public static void main( String[] args ) throws Exception {

        CloseableHttpClient httpclient = HttpClients.custom()
            .setSSLSocketFactory(getSSLFactory())
            .build();

        long start = System.currentTimeMillis();
        
        InputStream http = BenchmarkCrawler.class.getClassLoader().getResourceAsStream("benchmark-crawler-http.xml");

        List<HttpPost> posts = parseHttpFile( httpclient, http );
        for ( HttpPost post : posts ) {
            try {
                sendPost( httpclient, post );
            } catch( Exception e ) {
                System.err.println( "\n  FAILED: " + e.getMessage() );
                e.printStackTrace();
            }
        }
        
        long stop = System.currentTimeMillis();
        double seconds = ( stop - start ) / 1000;
        System.out.println( "\n\nElapsed time " + seconds + " seconds" );

    }
    
    public static List<HttpPost> parseHttpFile( CloseableHttpClient httpclient, InputStream http ) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource( http );
        Document doc = docBuilder.parse(is);
        Node root = doc.getDocumentElement();

        List<HttpPost> posts = new ArrayList<HttpPost>();
        List<Node> tests = getNamedChildren( "benchmarkTest", root );
        for ( Node test : tests ) {
            HttpPost post = parseHttpTest( httpclient, test );
            posts.add( post );
        }
        return posts;
    }

    
    public static void sendPost( CloseableHttpClient httpclient, HttpPost post ) throws Exception {
        CloseableHttpResponse response = httpclient.execute(post);
        System.out.println( "POST " + post.getURI() );
        try {
            HttpEntity entity = response.getEntity();
//            System.err.println( EntityUtils.toString( entity ) );
            System.out.println("--> (" + response.getStatusLine().getStatusCode() + ") " );
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
    }
        
    public static SSLConnectionSocketFactory getSSLFactory() throws Exception {
        
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                .build();

        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                NoopHostnameVerifier.INSTANCE);
        
        return sslsf;
    }

       
    /***************************** Read HTTP REQUEST XML File ***************/

    public static HttpPost parseHttpTest( CloseableHttpClient httpclient, Node test ) throws Exception {
        
        List<Node> headers = getNamedChildren("header", test);
        List<Node> cookies = getNamedChildren("cookie", test);
        List<Node> getParams = getNamedChildren("getparam", test);
        List<Node> formParams = getNamedChildren("formparam", test);
        
        String query = "";
        String number = getAttributeValue("name", test);
        boolean first = true;
        for ( Node field : getParams ) {
            if ( !first ) {
                first = false;
                query += "&";
            }
            String name = getAttributeValue( "name", field );
            String value = getAttributeValue( "value", field );
            query += name + "=" + URLEncoder.encode(value);
        }        
      
        String fullURL = url + number;
        if ( !query.isEmpty() ) {
            fullURL += "?" + query;
        }
        HttpPost httpPost = new HttpPost( fullURL );
        for ( Node header : headers ) {
            String name = getAttributeValue( "name", header );
            String value = getAttributeValue( "value", header );
            httpPost.addHeader(name, value);
        }
        for ( Node cookie : cookies ) {
            String name = getAttributeValue( "name", cookie );
            String value = getAttributeValue( "value", cookie );
            httpPost.addHeader("Cookie", name + "=" + value);
        }
        
        List<NameValuePair> fields = new ArrayList<NameValuePair>();
        for ( Node field : formParams ) {
            String name = getAttributeValue( "name", field );
            String value = getAttributeValue( "value", field );
            NameValuePair nvp = new BasicNameValuePair( name, value );
            fields.add( nvp );
        }
        httpPost.setEntity(new UrlEncodedFormEntity(fields));
        return httpPost;
    }

    
    /***************************** XML STUFF ****************************/
    
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
        return getNamedNode( name, children );
    }

    public static List<Node> getNamedChildren(String name, List<Node> list) {
        List<Node> results = new ArrayList<Node>();
        for (Node n : list) {
            NodeList children = n.getChildNodes();
            for ( int i=0; i<children.getLength(); i++ ) {
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
        return getNamedNodes( name, children );
    }
        
    public static List<Node> getNamedNodes(String name, NodeList list) {
        List<Node> results = new ArrayList<Node>();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (n.getNodeName().equals(name)) {
                // System.out.println(">> " + n.getNodeName() + "::" + n.getNodeValue());
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
                return value;
            }
        }
        return null;
    }    
}
