package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04311")
public class BenchmarkTest04311 extends HttpServlet {
	
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
		String a23999 = param; //assign
		StringBuilder b23999 = new StringBuilder(a23999);  // stick in stringbuilder
		b23999.append(" SafeStuff"); // append some safe content
		b23999.replace(b23999.length()-"Chars".length(),b23999.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23999 = new java.util.HashMap<String,Object>();
		map23999.put("key23999", b23999.toString()); // put in a collection
		String c23999 = (String)map23999.get("key23999"); // get it back out
		String d23999 = c23999.substring(0,c23999.length()-1); // extract most of it
		String e23999 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23999.getBytes() ) )); // B64 encode and decode it
		String f23999 = e23999.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23999 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23999); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
