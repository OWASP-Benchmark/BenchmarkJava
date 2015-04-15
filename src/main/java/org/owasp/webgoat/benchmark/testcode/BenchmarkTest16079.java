package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16079")
public class BenchmarkTest16079 extends HttpServlet {
	
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
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a78645 = param; //assign
		StringBuilder b78645 = new StringBuilder(a78645);  // stick in stringbuilder
		b78645.append(" SafeStuff"); // append some safe content
		b78645.replace(b78645.length()-"Chars".length(),b78645.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78645 = new java.util.HashMap<String,Object>();
		map78645.put("key78645", b78645.toString()); // put in a collection
		String c78645 = (String)map78645.get("key78645"); // get it back out
		String d78645 = c78645.substring(0,c78645.length()-1); // extract most of it
		String e78645 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78645.getBytes() ) )); // B64 encode and decode it
		String f78645 = e78645.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f78645); // reflection
	
		return bar;	
	}
}
