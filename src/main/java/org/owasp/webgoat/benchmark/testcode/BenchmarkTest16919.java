package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16919")
public class BenchmarkTest16919 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a25371 = param; //assign
		StringBuilder b25371 = new StringBuilder(a25371);  // stick in stringbuilder
		b25371.append(" SafeStuff"); // append some safe content
		b25371.replace(b25371.length()-"Chars".length(),b25371.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25371 = new java.util.HashMap<String,Object>();
		map25371.put("key25371", b25371.toString()); // put in a collection
		String c25371 = (String)map25371.get("key25371"); // get it back out
		String d25371 = c25371.substring(0,c25371.length()-1); // extract most of it
		String e25371 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25371.getBytes() ) )); // B64 encode and decode it
		String f25371 = e25371.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f25371); // reflection
	
		return bar;	
	}
}
