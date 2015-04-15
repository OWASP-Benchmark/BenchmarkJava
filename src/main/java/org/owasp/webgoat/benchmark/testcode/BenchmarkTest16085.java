package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16085")
public class BenchmarkTest16085 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
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
		String a4116 = param; //assign
		StringBuilder b4116 = new StringBuilder(a4116);  // stick in stringbuilder
		b4116.append(" SafeStuff"); // append some safe content
		b4116.replace(b4116.length()-"Chars".length(),b4116.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4116 = new java.util.HashMap<String,Object>();
		map4116.put("key4116", b4116.toString()); // put in a collection
		String c4116 = (String)map4116.get("key4116"); // get it back out
		String d4116 = c4116.substring(0,c4116.length()-1); // extract most of it
		String e4116 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4116.getBytes() ) )); // B64 encode and decode it
		String f4116 = e4116.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4116); // reflection
	
		return bar;	
	}
}
