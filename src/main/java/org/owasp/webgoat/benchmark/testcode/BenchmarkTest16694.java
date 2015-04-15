package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16694")
public class BenchmarkTest16694 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a77691 = param; //assign
		StringBuilder b77691 = new StringBuilder(a77691);  // stick in stringbuilder
		b77691.append(" SafeStuff"); // append some safe content
		b77691.replace(b77691.length()-"Chars".length(),b77691.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77691 = new java.util.HashMap<String,Object>();
		map77691.put("key77691", b77691.toString()); // put in a collection
		String c77691 = (String)map77691.get("key77691"); // get it back out
		String d77691 = c77691.substring(0,c77691.length()-1); // extract most of it
		String e77691 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77691.getBytes() ) )); // B64 encode and decode it
		String f77691 = e77691.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g77691 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77691); // reflection
	
		return bar;	
	}
}
