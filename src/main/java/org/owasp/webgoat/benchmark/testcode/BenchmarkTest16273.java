package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16273")
public class BenchmarkTest16273 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11068 = param; //assign
		StringBuilder b11068 = new StringBuilder(a11068);  // stick in stringbuilder
		b11068.append(" SafeStuff"); // append some safe content
		b11068.replace(b11068.length()-"Chars".length(),b11068.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11068 = new java.util.HashMap<String,Object>();
		map11068.put("key11068", b11068.toString()); // put in a collection
		String c11068 = (String)map11068.get("key11068"); // get it back out
		String d11068 = c11068.substring(0,c11068.length()-1); // extract most of it
		String e11068 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11068.getBytes() ) )); // B64 encode and decode it
		String f11068 = e11068.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g11068 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11068); // reflection
	
		return bar;	
	}
}
