package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05430")
public class BenchmarkTest05430 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a77258 = param; //assign
		StringBuilder b77258 = new StringBuilder(a77258);  // stick in stringbuilder
		b77258.append(" SafeStuff"); // append some safe content
		b77258.replace(b77258.length()-"Chars".length(),b77258.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77258 = new java.util.HashMap<String,Object>();
		map77258.put("key77258", b77258.toString()); // put in a collection
		String c77258 = (String)map77258.get("key77258"); // get it back out
		String d77258 = c77258.substring(0,c77258.length()-1); // extract most of it
		String e77258 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77258.getBytes() ) )); // B64 encode and decode it
		String f77258 = e77258.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g77258 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77258); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
