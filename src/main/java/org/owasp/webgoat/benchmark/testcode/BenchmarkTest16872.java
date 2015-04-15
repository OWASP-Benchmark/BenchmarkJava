package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16872")
public class BenchmarkTest16872 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67591 = param; //assign
		StringBuilder b67591 = new StringBuilder(a67591);  // stick in stringbuilder
		b67591.append(" SafeStuff"); // append some safe content
		b67591.replace(b67591.length()-"Chars".length(),b67591.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67591 = new java.util.HashMap<String,Object>();
		map67591.put("key67591", b67591.toString()); // put in a collection
		String c67591 = (String)map67591.get("key67591"); // get it back out
		String d67591 = c67591.substring(0,c67591.length()-1); // extract most of it
		String e67591 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67591.getBytes() ) )); // B64 encode and decode it
		String f67591 = e67591.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g67591 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g67591); // reflection
	
		return bar;	
	}
}
