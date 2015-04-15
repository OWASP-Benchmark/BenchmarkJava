package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19584")
public class BenchmarkTest19584 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93392 = param; //assign
		StringBuilder b93392 = new StringBuilder(a93392);  // stick in stringbuilder
		b93392.append(" SafeStuff"); // append some safe content
		b93392.replace(b93392.length()-"Chars".length(),b93392.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93392 = new java.util.HashMap<String,Object>();
		map93392.put("key93392", b93392.toString()); // put in a collection
		String c93392 = (String)map93392.get("key93392"); // get it back out
		String d93392 = c93392.substring(0,c93392.length()-1); // extract most of it
		String e93392 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93392.getBytes() ) )); // B64 encode and decode it
		String f93392 = e93392.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93392 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93392); // reflection
	
		return bar;	
	}
}
