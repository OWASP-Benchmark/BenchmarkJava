package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19605")
public class BenchmarkTest19605 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45483 = param; //assign
		StringBuilder b45483 = new StringBuilder(a45483);  // stick in stringbuilder
		b45483.append(" SafeStuff"); // append some safe content
		b45483.replace(b45483.length()-"Chars".length(),b45483.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45483 = new java.util.HashMap<String,Object>();
		map45483.put("key45483", b45483.toString()); // put in a collection
		String c45483 = (String)map45483.get("key45483"); // get it back out
		String d45483 = c45483.substring(0,c45483.length()-1); // extract most of it
		String e45483 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45483.getBytes() ) )); // B64 encode and decode it
		String f45483 = e45483.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45483); // reflection
	
		return bar;	
	}
}
