package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20069")
public class BenchmarkTest20069 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35948 = param; //assign
		StringBuilder b35948 = new StringBuilder(a35948);  // stick in stringbuilder
		b35948.append(" SafeStuff"); // append some safe content
		b35948.replace(b35948.length()-"Chars".length(),b35948.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35948 = new java.util.HashMap<String,Object>();
		map35948.put("key35948", b35948.toString()); // put in a collection
		String c35948 = (String)map35948.get("key35948"); // get it back out
		String d35948 = c35948.substring(0,c35948.length()-1); // extract most of it
		String e35948 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35948.getBytes() ) )); // B64 encode and decode it
		String f35948 = e35948.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35948); // reflection
	
		return bar;	
	}
}
