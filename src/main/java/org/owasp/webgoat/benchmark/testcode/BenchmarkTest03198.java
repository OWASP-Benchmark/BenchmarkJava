package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03198")
public class BenchmarkTest03198 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a93341 = param; //assign
		StringBuilder b93341 = new StringBuilder(a93341);  // stick in stringbuilder
		b93341.append(" SafeStuff"); // append some safe content
		b93341.replace(b93341.length()-"Chars".length(),b93341.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93341 = new java.util.HashMap<String,Object>();
		map93341.put("key93341", b93341.toString()); // put in a collection
		String c93341 = (String)map93341.get("key93341"); // get it back out
		String d93341 = c93341.substring(0,c93341.length()-1); // extract most of it
		String e93341 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93341.getBytes() ) )); // B64 encode and decode it
		String f93341 = e93341.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93341 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93341); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
