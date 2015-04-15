package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14955")
public class BenchmarkTest14955 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a2602 = param; //assign
		StringBuilder b2602 = new StringBuilder(a2602);  // stick in stringbuilder
		b2602.append(" SafeStuff"); // append some safe content
		b2602.replace(b2602.length()-"Chars".length(),b2602.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2602 = new java.util.HashMap<String,Object>();
		map2602.put("key2602", b2602.toString()); // put in a collection
		String c2602 = (String)map2602.get("key2602"); // get it back out
		String d2602 = c2602.substring(0,c2602.length()-1); // extract most of it
		String e2602 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2602.getBytes() ) )); // B64 encode and decode it
		String f2602 = e2602.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g2602 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g2602); // reflection
	
		return bar;	
	}
}
