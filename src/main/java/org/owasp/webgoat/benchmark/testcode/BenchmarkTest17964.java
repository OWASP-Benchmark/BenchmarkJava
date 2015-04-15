package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17964")
public class BenchmarkTest17964 extends HttpServlet {
	
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
		String a18976 = param; //assign
		StringBuilder b18976 = new StringBuilder(a18976);  // stick in stringbuilder
		b18976.append(" SafeStuff"); // append some safe content
		b18976.replace(b18976.length()-"Chars".length(),b18976.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18976 = new java.util.HashMap<String,Object>();
		map18976.put("key18976", b18976.toString()); // put in a collection
		String c18976 = (String)map18976.get("key18976"); // get it back out
		String d18976 = c18976.substring(0,c18976.length()-1); // extract most of it
		String e18976 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18976.getBytes() ) )); // B64 encode and decode it
		String f18976 = e18976.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18976 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18976); // reflection
	
		return bar;	
	}
}
