package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15656")
public class BenchmarkTest15656 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a65952 = param; //assign
		StringBuilder b65952 = new StringBuilder(a65952);  // stick in stringbuilder
		b65952.append(" SafeStuff"); // append some safe content
		b65952.replace(b65952.length()-"Chars".length(),b65952.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65952 = new java.util.HashMap<String,Object>();
		map65952.put("key65952", b65952.toString()); // put in a collection
		String c65952 = (String)map65952.get("key65952"); // get it back out
		String d65952 = c65952.substring(0,c65952.length()-1); // extract most of it
		String e65952 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65952.getBytes() ) )); // B64 encode and decode it
		String f65952 = e65952.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f65952); // reflection
	
		return bar;	
	}
}
