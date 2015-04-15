package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16932")
public class BenchmarkTest16932 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20871 = param; //assign
		StringBuilder b20871 = new StringBuilder(a20871);  // stick in stringbuilder
		b20871.append(" SafeStuff"); // append some safe content
		b20871.replace(b20871.length()-"Chars".length(),b20871.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20871 = new java.util.HashMap<String,Object>();
		map20871.put("key20871", b20871.toString()); // put in a collection
		String c20871 = (String)map20871.get("key20871"); // get it back out
		String d20871 = c20871.substring(0,c20871.length()-1); // extract most of it
		String e20871 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20871.getBytes() ) )); // B64 encode and decode it
		String f20871 = e20871.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g20871 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g20871); // reflection
	
		return bar;	
	}
}
