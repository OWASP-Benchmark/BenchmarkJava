package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19522")
public class BenchmarkTest19522 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43527 = param; //assign
		StringBuilder b43527 = new StringBuilder(a43527);  // stick in stringbuilder
		b43527.append(" SafeStuff"); // append some safe content
		b43527.replace(b43527.length()-"Chars".length(),b43527.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43527 = new java.util.HashMap<String,Object>();
		map43527.put("key43527", b43527.toString()); // put in a collection
		String c43527 = (String)map43527.get("key43527"); // get it back out
		String d43527 = c43527.substring(0,c43527.length()-1); // extract most of it
		String e43527 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43527.getBytes() ) )); // B64 encode and decode it
		String f43527 = e43527.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43527 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43527); // reflection
	
		return bar;	
	}
}
