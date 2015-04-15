package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19393")
public class BenchmarkTest19393 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1684 = param; //assign
		StringBuilder b1684 = new StringBuilder(a1684);  // stick in stringbuilder
		b1684.append(" SafeStuff"); // append some safe content
		b1684.replace(b1684.length()-"Chars".length(),b1684.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1684 = new java.util.HashMap<String,Object>();
		map1684.put("key1684", b1684.toString()); // put in a collection
		String c1684 = (String)map1684.get("key1684"); // get it back out
		String d1684 = c1684.substring(0,c1684.length()-1); // extract most of it
		String e1684 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1684.getBytes() ) )); // B64 encode and decode it
		String f1684 = e1684.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1684); // reflection
	
		return bar;	
	}
}
