package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03289")
public class BenchmarkTest03289 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a54806 = param; //assign
		StringBuilder b54806 = new StringBuilder(a54806);  // stick in stringbuilder
		b54806.append(" SafeStuff"); // append some safe content
		b54806.replace(b54806.length()-"Chars".length(),b54806.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54806 = new java.util.HashMap<String,Object>();
		map54806.put("key54806", b54806.toString()); // put in a collection
		String c54806 = (String)map54806.get("key54806"); // get it back out
		String d54806 = c54806.substring(0,c54806.length()-1); // extract most of it
		String e54806 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54806.getBytes() ) )); // B64 encode and decode it
		String f54806 = e54806.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g54806 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g54806); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
