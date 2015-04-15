package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01080")
public class BenchmarkTest01080 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a59941 = param; //assign
		StringBuilder b59941 = new StringBuilder(a59941);  // stick in stringbuilder
		b59941.append(" SafeStuff"); // append some safe content
		b59941.replace(b59941.length()-"Chars".length(),b59941.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59941 = new java.util.HashMap<String,Object>();
		map59941.put("key59941", b59941.toString()); // put in a collection
		String c59941 = (String)map59941.get("key59941"); // get it back out
		String d59941 = c59941.substring(0,c59941.length()-1); // extract most of it
		String e59941 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59941.getBytes() ) )); // B64 encode and decode it
		String f59941 = e59941.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g59941 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59941); // reflection
		
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
