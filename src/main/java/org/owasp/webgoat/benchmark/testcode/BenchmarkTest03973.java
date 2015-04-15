package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03973")
public class BenchmarkTest03973 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a1526 = param; //assign
		StringBuilder b1526 = new StringBuilder(a1526);  // stick in stringbuilder
		b1526.append(" SafeStuff"); // append some safe content
		b1526.replace(b1526.length()-"Chars".length(),b1526.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1526 = new java.util.HashMap<String,Object>();
		map1526.put("key1526", b1526.toString()); // put in a collection
		String c1526 = (String)map1526.get("key1526"); // get it back out
		String d1526 = c1526.substring(0,c1526.length()-1); // extract most of it
		String e1526 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1526.getBytes() ) )); // B64 encode and decode it
		String f1526 = e1526.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1526 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1526); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
