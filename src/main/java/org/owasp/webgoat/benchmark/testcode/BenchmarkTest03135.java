package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03135")
public class BenchmarkTest03135 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a43622 = param; //assign
		StringBuilder b43622 = new StringBuilder(a43622);  // stick in stringbuilder
		b43622.append(" SafeStuff"); // append some safe content
		b43622.replace(b43622.length()-"Chars".length(),b43622.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43622 = new java.util.HashMap<String,Object>();
		map43622.put("key43622", b43622.toString()); // put in a collection
		String c43622 = (String)map43622.get("key43622"); // get it back out
		String d43622 = c43622.substring(0,c43622.length()-1); // extract most of it
		String e43622 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43622.getBytes() ) )); // B64 encode and decode it
		String f43622 = e43622.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43622 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43622); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}
}
