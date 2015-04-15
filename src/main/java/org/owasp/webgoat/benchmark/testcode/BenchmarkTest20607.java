package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20607")
public class BenchmarkTest20607 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95622 = param; //assign
		StringBuilder b95622 = new StringBuilder(a95622);  // stick in stringbuilder
		b95622.append(" SafeStuff"); // append some safe content
		b95622.replace(b95622.length()-"Chars".length(),b95622.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95622 = new java.util.HashMap<String,Object>();
		map95622.put("key95622", b95622.toString()); // put in a collection
		String c95622 = (String)map95622.get("key95622"); // get it back out
		String d95622 = c95622.substring(0,c95622.length()-1); // extract most of it
		String e95622 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95622.getBytes() ) )); // B64 encode and decode it
		String f95622 = e95622.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95622); // reflection
	
		return bar;	
	}
}
