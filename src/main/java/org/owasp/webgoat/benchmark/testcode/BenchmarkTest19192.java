package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19192")
public class BenchmarkTest19192 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a39022 = param; //assign
		StringBuilder b39022 = new StringBuilder(a39022);  // stick in stringbuilder
		b39022.append(" SafeStuff"); // append some safe content
		b39022.replace(b39022.length()-"Chars".length(),b39022.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39022 = new java.util.HashMap<String,Object>();
		map39022.put("key39022", b39022.toString()); // put in a collection
		String c39022 = (String)map39022.get("key39022"); // get it back out
		String d39022 = c39022.substring(0,c39022.length()-1); // extract most of it
		String e39022 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39022.getBytes() ) )); // B64 encode and decode it
		String f39022 = e39022.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g39022 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g39022); // reflection
	
		return bar;	
	}
}
