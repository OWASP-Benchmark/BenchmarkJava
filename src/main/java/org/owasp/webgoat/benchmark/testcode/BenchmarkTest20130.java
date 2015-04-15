package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20130")
public class BenchmarkTest20130 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27899 = param; //assign
		StringBuilder b27899 = new StringBuilder(a27899);  // stick in stringbuilder
		b27899.append(" SafeStuff"); // append some safe content
		b27899.replace(b27899.length()-"Chars".length(),b27899.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27899 = new java.util.HashMap<String,Object>();
		map27899.put("key27899", b27899.toString()); // put in a collection
		String c27899 = (String)map27899.get("key27899"); // get it back out
		String d27899 = c27899.substring(0,c27899.length()-1); // extract most of it
		String e27899 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27899.getBytes() ) )); // B64 encode and decode it
		String f27899 = e27899.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27899); // reflection
	
		return bar;	
	}
}
