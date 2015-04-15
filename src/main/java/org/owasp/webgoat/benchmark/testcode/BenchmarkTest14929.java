package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14929")
public class BenchmarkTest14929 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a844 = param; //assign
		StringBuilder b844 = new StringBuilder(a844);  // stick in stringbuilder
		b844.append(" SafeStuff"); // append some safe content
		b844.replace(b844.length()-"Chars".length(),b844.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map844 = new java.util.HashMap<String,Object>();
		map844.put("key844", b844.toString()); // put in a collection
		String c844 = (String)map844.get("key844"); // get it back out
		String d844 = c844.substring(0,c844.length()-1); // extract most of it
		String e844 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d844.getBytes() ) )); // B64 encode and decode it
		String f844 = e844.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g844 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g844); // reflection
	
		return bar;	
	}
}
