package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16216")
public class BenchmarkTest16216 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83438 = param; //assign
		StringBuilder b83438 = new StringBuilder(a83438);  // stick in stringbuilder
		b83438.append(" SafeStuff"); // append some safe content
		b83438.replace(b83438.length()-"Chars".length(),b83438.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83438 = new java.util.HashMap<String,Object>();
		map83438.put("key83438", b83438.toString()); // put in a collection
		String c83438 = (String)map83438.get("key83438"); // get it back out
		String d83438 = c83438.substring(0,c83438.length()-1); // extract most of it
		String e83438 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83438.getBytes() ) )); // B64 encode and decode it
		String f83438 = e83438.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83438); // reflection
	
		return bar;	
	}
}
