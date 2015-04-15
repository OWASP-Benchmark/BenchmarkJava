package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15089")
public class BenchmarkTest15089 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9899 = param; //assign
		StringBuilder b9899 = new StringBuilder(a9899);  // stick in stringbuilder
		b9899.append(" SafeStuff"); // append some safe content
		b9899.replace(b9899.length()-"Chars".length(),b9899.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9899 = new java.util.HashMap<String,Object>();
		map9899.put("key9899", b9899.toString()); // put in a collection
		String c9899 = (String)map9899.get("key9899"); // get it back out
		String d9899 = c9899.substring(0,c9899.length()-1); // extract most of it
		String e9899 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9899.getBytes() ) )); // B64 encode and decode it
		String f9899 = e9899.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g9899 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9899); // reflection
	
		return bar;	
	}
}
