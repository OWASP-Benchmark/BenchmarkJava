package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19872")
public class BenchmarkTest19872 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a13662 = param; //assign
		StringBuilder b13662 = new StringBuilder(a13662);  // stick in stringbuilder
		b13662.append(" SafeStuff"); // append some safe content
		b13662.replace(b13662.length()-"Chars".length(),b13662.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13662 = new java.util.HashMap<String,Object>();
		map13662.put("key13662", b13662.toString()); // put in a collection
		String c13662 = (String)map13662.get("key13662"); // get it back out
		String d13662 = c13662.substring(0,c13662.length()-1); // extract most of it
		String e13662 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13662.getBytes() ) )); // B64 encode and decode it
		String f13662 = e13662.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13662 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13662); // reflection
	
		return bar;	
	}
}
