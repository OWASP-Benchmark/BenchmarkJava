package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17299")
public class BenchmarkTest17299 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
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
		String a50463 = param; //assign
		StringBuilder b50463 = new StringBuilder(a50463);  // stick in stringbuilder
		b50463.append(" SafeStuff"); // append some safe content
		b50463.replace(b50463.length()-"Chars".length(),b50463.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50463 = new java.util.HashMap<String,Object>();
		map50463.put("key50463", b50463.toString()); // put in a collection
		String c50463 = (String)map50463.get("key50463"); // get it back out
		String d50463 = c50463.substring(0,c50463.length()-1); // extract most of it
		String e50463 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50463.getBytes() ) )); // B64 encode and decode it
		String f50463 = e50463.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50463); // reflection
	
		return bar;	
	}
}
