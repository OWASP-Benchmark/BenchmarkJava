package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18604")
public class BenchmarkTest18604 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76377 = param; //assign
		StringBuilder b76377 = new StringBuilder(a76377);  // stick in stringbuilder
		b76377.append(" SafeStuff"); // append some safe content
		b76377.replace(b76377.length()-"Chars".length(),b76377.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76377 = new java.util.HashMap<String,Object>();
		map76377.put("key76377", b76377.toString()); // put in a collection
		String c76377 = (String)map76377.get("key76377"); // get it back out
		String d76377 = c76377.substring(0,c76377.length()-1); // extract most of it
		String e76377 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76377.getBytes() ) )); // B64 encode and decode it
		String f76377 = e76377.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76377 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76377); // reflection
	
		return bar;	
	}
}
