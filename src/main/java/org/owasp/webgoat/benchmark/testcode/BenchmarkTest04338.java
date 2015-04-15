package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04338")
public class BenchmarkTest04338 extends HttpServlet {
	
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
		String a99676 = param; //assign
		StringBuilder b99676 = new StringBuilder(a99676);  // stick in stringbuilder
		b99676.append(" SafeStuff"); // append some safe content
		b99676.replace(b99676.length()-"Chars".length(),b99676.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99676 = new java.util.HashMap<String,Object>();
		map99676.put("key99676", b99676.toString()); // put in a collection
		String c99676 = (String)map99676.get("key99676"); // get it back out
		String d99676 = c99676.substring(0,c99676.length()-1); // extract most of it
		String e99676 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99676.getBytes() ) )); // B64 encode and decode it
		String f99676 = e99676.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g99676 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g99676); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
