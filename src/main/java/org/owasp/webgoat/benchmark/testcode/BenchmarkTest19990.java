package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19990")
public class BenchmarkTest19990 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29569 = param; //assign
		StringBuilder b29569 = new StringBuilder(a29569);  // stick in stringbuilder
		b29569.append(" SafeStuff"); // append some safe content
		b29569.replace(b29569.length()-"Chars".length(),b29569.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29569 = new java.util.HashMap<String,Object>();
		map29569.put("key29569", b29569.toString()); // put in a collection
		String c29569 = (String)map29569.get("key29569"); // get it back out
		String d29569 = c29569.substring(0,c29569.length()-1); // extract most of it
		String e29569 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29569.getBytes() ) )); // B64 encode and decode it
		String f29569 = e29569.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29569); // reflection
	
		return bar;	
	}
}
