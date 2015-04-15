package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04352")
public class BenchmarkTest04352 extends HttpServlet {
	
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
		String a75555 = param; //assign
		StringBuilder b75555 = new StringBuilder(a75555);  // stick in stringbuilder
		b75555.append(" SafeStuff"); // append some safe content
		b75555.replace(b75555.length()-"Chars".length(),b75555.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75555 = new java.util.HashMap<String,Object>();
		map75555.put("key75555", b75555.toString()); // put in a collection
		String c75555 = (String)map75555.get("key75555"); // get it back out
		String d75555 = c75555.substring(0,c75555.length()-1); // extract most of it
		String e75555 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75555.getBytes() ) )); // B64 encode and decode it
		String f75555 = e75555.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g75555 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75555); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
