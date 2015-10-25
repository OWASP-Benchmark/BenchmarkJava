package org.owasp.benchmark.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NoisyCricket {

    private static Element vulns = null;
    private static Document report = null;
    
    public static void main(String[] args) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    		// Prevent XXE
    		docFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            report = docBuilder.newDocument();
            
            Element docroot = report.createElement("noisycricket");
            report.appendChild( docroot );

            Element version = report.createElement("meta");
            version.setAttribute("tool", "NoisyCricket");
            version.setAttribute("version", "8.1");
            version.setAttribute("url", "http://owasp.org/benchmark");
            docroot.appendChild( version );
            
            vulns = report.createElement("vulnerabilities");
            docroot.appendChild(vulns);

            FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    Objects.requireNonNull(path);
                    Objects.requireNonNull(attrs);
                    if ( path.toString().endsWith(".java")) {
                        analyze(path);   
                    }
                    return FileVisitResult.CONTINUE;
                }
            };
            // TODO - Change user.home to be the home directory of the Benchmark project.
            Path p = FileSystems.getDefault().getPath( System.getProperty("user.home") );
            Files.walkFileTree(p, visitor);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(report);
            StreamResult result = new StreamResult(new FileWriter(new File( "NoisyCricket.xml" )));
            transformer.transform(source, result);

            System.out.println("\n\nNoisyCricket.xml saved!");

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static void analyze( Path p ) throws IOException {
        Element vuln = report.createElement("vulnerability");
        List<String> lines = Files.readAllLines(p, Charset.defaultCharset() );
        Set<Integer> cwelist = new TreeSet<Integer>();
        
        for ( String line : lines ) {
            if ( checkSQL( line ) ) { cwelist.add( 89 ); }
            if ( checkXSS( line ) ) { cwelist.add( 79 ); }
            if ( checkLDAP( line ) ) { cwelist.add( 90 ); }
            if ( checkCommandInjection( line ) ) { cwelist.add( 78 ); }
            if ( checkPathTraversal( line ) ) { cwelist.add( 22 ); }
            if ( checkCookie( line ) ) { cwelist.add( 614 ); }
            if ( checkXpath( line ) ) { cwelist.add( 643 ); }
            if ( checkRandom( line ) ) { cwelist.add( 330 ); }
            if ( checkCrypto( line ) ) { cwelist.add( 327 ); }
            if ( checkHash( line ) ) { cwelist.add( 328 ); }
            if ( checkTrustBoundary( line ) ) { cwelist.add( 501 ); }
        }
        
        vuln.setAttribute("cwelist", cwelist.toString() );
        vuln.setAttribute("file", p.getFileName().toString() );
        vulns.appendChild(vuln);
    }

    private static boolean checkLDAP(String line) {
        if ( match( line, "ldap" ) ) return true;
        return false;
    }

    private static boolean checkCommandInjection(String line) {
        if ( match( line, "exec" ) ) return true;
        return false;
    }

    private static boolean checkPathTraversal(String line) {
        if ( match( line, "file" ) ) return true;
        return false;
    }

    private static boolean checkCookie(String line) {
        if ( match( line, "setsecure" ) && match( line, "false" ) ) return true;
        return false;
    }

    private static boolean checkXpath(String line) {
        if ( match( line, "xpath" ) ) return true;
        return false;
    }

    private static boolean checkRandom(String line) {
        if ( match( line, "random" ) ) return true;
        return false;
    }

    private static boolean checkCrypto(String line) {
        if ( match( line, "cipher" ) ) return true;
        return false;
    }

    private static boolean checkHash(String line) {
        if ( match( line, "digest" ) ) return true;
        return false;
    }

    private static boolean checkTrustBoundary(String line) {
        if ( match( line, "putValue" ) ) return true;
        if ( match( line, "setAttribute" ) ) return true;
        return false;
    }

    public static boolean checkSQL( String line ) {
        if ( match( line, "sql" ) ) return true;
        return false;
    }
    
    public static boolean checkXSS( String line ) {
        if ( match( line, "getWriter" ) ) return true;
        if ( match( line, "getOutputStream" ) ) return true;
        return false;
    }
    
    private static boolean match(String line, String string) {
        return line.toLowerCase().contains( string.toLowerCase() );
    }
            
}
