package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14807")
public class BenchmarkTest14807 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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
		String a61315 = param; //assign
		StringBuilder b61315 = new StringBuilder(a61315);  // stick in stringbuilder
		b61315.append(" SafeStuff"); // append some safe content
		b61315.replace(b61315.length()-"Chars".length(),b61315.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61315 = new java.util.HashMap<String,Object>();
		map61315.put("key61315", b61315.toString()); // put in a collection
		String c61315 = (String)map61315.get("key61315"); // get it back out
		String d61315 = c61315.substring(0,c61315.length()-1); // extract most of it
		String e61315 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61315.getBytes() ) )); // B64 encode and decode it
		String f61315 = e61315.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f61315); // reflection
	
		return bar;	
	}
}
