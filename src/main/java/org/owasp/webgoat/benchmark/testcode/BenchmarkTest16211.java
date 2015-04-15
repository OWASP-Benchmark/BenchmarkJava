package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16211")
public class BenchmarkTest16211 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23197 = param; //assign
		StringBuilder b23197 = new StringBuilder(a23197);  // stick in stringbuilder
		b23197.append(" SafeStuff"); // append some safe content
		b23197.replace(b23197.length()-"Chars".length(),b23197.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23197 = new java.util.HashMap<String,Object>();
		map23197.put("key23197", b23197.toString()); // put in a collection
		String c23197 = (String)map23197.get("key23197"); // get it back out
		String d23197 = c23197.substring(0,c23197.length()-1); // extract most of it
		String e23197 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23197.getBytes() ) )); // B64 encode and decode it
		String f23197 = e23197.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23197 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23197); // reflection
	
		return bar;	
	}
}
