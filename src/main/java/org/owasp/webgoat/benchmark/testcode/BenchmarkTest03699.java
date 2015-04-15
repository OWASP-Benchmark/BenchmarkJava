package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03699")
public class BenchmarkTest03699 extends HttpServlet {
	
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
		String a23950 = param; //assign
		StringBuilder b23950 = new StringBuilder(a23950);  // stick in stringbuilder
		b23950.append(" SafeStuff"); // append some safe content
		b23950.replace(b23950.length()-"Chars".length(),b23950.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23950 = new java.util.HashMap<String,Object>();
		map23950.put("key23950", b23950.toString()); // put in a collection
		String c23950 = (String)map23950.get("key23950"); // get it back out
		String d23950 = c23950.substring(0,c23950.length()-1); // extract most of it
		String e23950 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23950.getBytes() ) )); // B64 encode and decode it
		String f23950 = e23950.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23950 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23950); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
