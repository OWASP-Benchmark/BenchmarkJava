package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17961")
public class BenchmarkTest17961 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

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
		String a70611 = param; //assign
		StringBuilder b70611 = new StringBuilder(a70611);  // stick in stringbuilder
		b70611.append(" SafeStuff"); // append some safe content
		b70611.replace(b70611.length()-"Chars".length(),b70611.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70611 = new java.util.HashMap<String,Object>();
		map70611.put("key70611", b70611.toString()); // put in a collection
		String c70611 = (String)map70611.get("key70611"); // get it back out
		String d70611 = c70611.substring(0,c70611.length()-1); // extract most of it
		String e70611 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70611.getBytes() ) )); // B64 encode and decode it
		String f70611 = e70611.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70611); // reflection
	
		return bar;	
	}
}
