package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04577")
public class BenchmarkTest04577 extends HttpServlet {
	
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
		String a11625 = param; //assign
		StringBuilder b11625 = new StringBuilder(a11625);  // stick in stringbuilder
		b11625.append(" SafeStuff"); // append some safe content
		b11625.replace(b11625.length()-"Chars".length(),b11625.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11625 = new java.util.HashMap<String,Object>();
		map11625.put("key11625", b11625.toString()); // put in a collection
		String c11625 = (String)map11625.get("key11625"); // get it back out
		String d11625 = c11625.substring(0,c11625.length()-1); // extract most of it
		String e11625 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11625.getBytes() ) )); // B64 encode and decode it
		String f11625 = e11625.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g11625 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11625); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
