package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19937")
public class BenchmarkTest19937 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28250 = param; //assign
		StringBuilder b28250 = new StringBuilder(a28250);  // stick in stringbuilder
		b28250.append(" SafeStuff"); // append some safe content
		b28250.replace(b28250.length()-"Chars".length(),b28250.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28250 = new java.util.HashMap<String,Object>();
		map28250.put("key28250", b28250.toString()); // put in a collection
		String c28250 = (String)map28250.get("key28250"); // get it back out
		String d28250 = c28250.substring(0,c28250.length()-1); // extract most of it
		String e28250 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28250.getBytes() ) )); // B64 encode and decode it
		String f28250 = e28250.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g28250 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28250); // reflection
	
		return bar;	
	}
}
