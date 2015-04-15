package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06222")
public class BenchmarkTest06222 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a49720 = param; //assign
		StringBuilder b49720 = new StringBuilder(a49720);  // stick in stringbuilder
		b49720.append(" SafeStuff"); // append some safe content
		b49720.replace(b49720.length()-"Chars".length(),b49720.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49720 = new java.util.HashMap<String,Object>();
		map49720.put("key49720", b49720.toString()); // put in a collection
		String c49720 = (String)map49720.get("key49720"); // get it back out
		String d49720 = c49720.substring(0,c49720.length()-1); // extract most of it
		String e49720 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49720.getBytes() ) )); // B64 encode and decode it
		String f49720 = e49720.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49720 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49720); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
