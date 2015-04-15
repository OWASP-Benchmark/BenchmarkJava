package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16480")
public class BenchmarkTest16480 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27452 = param; //assign
		StringBuilder b27452 = new StringBuilder(a27452);  // stick in stringbuilder
		b27452.append(" SafeStuff"); // append some safe content
		b27452.replace(b27452.length()-"Chars".length(),b27452.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27452 = new java.util.HashMap<String,Object>();
		map27452.put("key27452", b27452.toString()); // put in a collection
		String c27452 = (String)map27452.get("key27452"); // get it back out
		String d27452 = c27452.substring(0,c27452.length()-1); // extract most of it
		String e27452 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27452.getBytes() ) )); // B64 encode and decode it
		String f27452 = e27452.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g27452 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g27452); // reflection
	
		return bar;	
	}
}
