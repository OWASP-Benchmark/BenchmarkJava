package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04556")
public class BenchmarkTest04556 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a97998 = param; //assign
		StringBuilder b97998 = new StringBuilder(a97998);  // stick in stringbuilder
		b97998.append(" SafeStuff"); // append some safe content
		b97998.replace(b97998.length()-"Chars".length(),b97998.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97998 = new java.util.HashMap<String,Object>();
		map97998.put("key97998", b97998.toString()); // put in a collection
		String c97998 = (String)map97998.get("key97998"); // get it back out
		String d97998 = c97998.substring(0,c97998.length()-1); // extract most of it
		String e97998 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97998.getBytes() ) )); // B64 encode and decode it
		String f97998 = e97998.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g97998 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97998); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
