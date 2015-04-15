package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01199")
public class BenchmarkTest01199 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a50520 = param; //assign
		StringBuilder b50520 = new StringBuilder(a50520);  // stick in stringbuilder
		b50520.append(" SafeStuff"); // append some safe content
		b50520.replace(b50520.length()-"Chars".length(),b50520.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50520 = new java.util.HashMap<String,Object>();
		map50520.put("key50520", b50520.toString()); // put in a collection
		String c50520 = (String)map50520.get("key50520"); // get it back out
		String d50520 = c50520.substring(0,c50520.length()-1); // extract most of it
		String e50520 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50520.getBytes() ) )); // B64 encode and decode it
		String f50520 = e50520.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g50520 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g50520); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
