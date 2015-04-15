package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16832")
public class BenchmarkTest16832 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33283 = param; //assign
		StringBuilder b33283 = new StringBuilder(a33283);  // stick in stringbuilder
		b33283.append(" SafeStuff"); // append some safe content
		b33283.replace(b33283.length()-"Chars".length(),b33283.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33283 = new java.util.HashMap<String,Object>();
		map33283.put("key33283", b33283.toString()); // put in a collection
		String c33283 = (String)map33283.get("key33283"); // get it back out
		String d33283 = c33283.substring(0,c33283.length()-1); // extract most of it
		String e33283 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33283.getBytes() ) )); // B64 encode and decode it
		String f33283 = e33283.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f33283); // reflection
	
		return bar;	
	}
}
