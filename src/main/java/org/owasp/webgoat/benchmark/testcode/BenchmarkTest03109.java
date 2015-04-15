package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03109")
public class BenchmarkTest03109 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a68012 = param; //assign
		StringBuilder b68012 = new StringBuilder(a68012);  // stick in stringbuilder
		b68012.append(" SafeStuff"); // append some safe content
		b68012.replace(b68012.length()-"Chars".length(),b68012.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68012 = new java.util.HashMap<String,Object>();
		map68012.put("key68012", b68012.toString()); // put in a collection
		String c68012 = (String)map68012.get("key68012"); // get it back out
		String d68012 = c68012.substring(0,c68012.length()-1); // extract most of it
		String e68012 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68012.getBytes() ) )); // B64 encode and decode it
		String f68012 = e68012.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g68012 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g68012); // reflection
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
