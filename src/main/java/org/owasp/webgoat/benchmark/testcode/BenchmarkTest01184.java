package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01184")
public class BenchmarkTest01184 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a29587 = param; //assign
		StringBuilder b29587 = new StringBuilder(a29587);  // stick in stringbuilder
		b29587.append(" SafeStuff"); // append some safe content
		b29587.replace(b29587.length()-"Chars".length(),b29587.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29587 = new java.util.HashMap<String,Object>();
		map29587.put("key29587", b29587.toString()); // put in a collection
		String c29587 = (String)map29587.get("key29587"); // get it back out
		String d29587 = c29587.substring(0,c29587.length()-1); // extract most of it
		String e29587 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29587.getBytes() ) )); // B64 encode and decode it
		String f29587 = e29587.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g29587 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g29587); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
