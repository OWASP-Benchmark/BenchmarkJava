package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01244")
public class BenchmarkTest01244 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a14983 = param; //assign
		StringBuilder b14983 = new StringBuilder(a14983);  // stick in stringbuilder
		b14983.append(" SafeStuff"); // append some safe content
		b14983.replace(b14983.length()-"Chars".length(),b14983.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14983 = new java.util.HashMap<String,Object>();
		map14983.put("key14983", b14983.toString()); // put in a collection
		String c14983 = (String)map14983.get("key14983"); // get it back out
		String d14983 = c14983.substring(0,c14983.length()-1); // extract most of it
		String e14983 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14983.getBytes() ) )); // B64 encode and decode it
		String f14983 = e14983.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g14983 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14983); // reflection
		
		
		response.getWriter().write(bar);
	}
}
