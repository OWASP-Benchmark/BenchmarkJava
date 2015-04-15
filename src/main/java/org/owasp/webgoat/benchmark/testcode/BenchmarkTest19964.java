package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19964")
public class BenchmarkTest19964 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64130 = param; //assign
		StringBuilder b64130 = new StringBuilder(a64130);  // stick in stringbuilder
		b64130.append(" SafeStuff"); // append some safe content
		b64130.replace(b64130.length()-"Chars".length(),b64130.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64130 = new java.util.HashMap<String,Object>();
		map64130.put("key64130", b64130.toString()); // put in a collection
		String c64130 = (String)map64130.get("key64130"); // get it back out
		String d64130 = c64130.substring(0,c64130.length()-1); // extract most of it
		String e64130 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64130.getBytes() ) )); // B64 encode and decode it
		String f64130 = e64130.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64130); // reflection
	
		return bar;	
	}
}
