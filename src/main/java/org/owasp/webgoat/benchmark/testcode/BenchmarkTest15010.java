package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15010")
public class BenchmarkTest15010 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38760 = param; //assign
		StringBuilder b38760 = new StringBuilder(a38760);  // stick in stringbuilder
		b38760.append(" SafeStuff"); // append some safe content
		b38760.replace(b38760.length()-"Chars".length(),b38760.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38760 = new java.util.HashMap<String,Object>();
		map38760.put("key38760", b38760.toString()); // put in a collection
		String c38760 = (String)map38760.get("key38760"); // get it back out
		String d38760 = c38760.substring(0,c38760.length()-1); // extract most of it
		String e38760 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38760.getBytes() ) )); // B64 encode and decode it
		String f38760 = e38760.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38760); // reflection
	
		return bar;	
	}
}
