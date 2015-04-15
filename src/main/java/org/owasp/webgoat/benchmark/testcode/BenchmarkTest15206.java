package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15206")
public class BenchmarkTest15206 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8322 = param; //assign
		StringBuilder b8322 = new StringBuilder(a8322);  // stick in stringbuilder
		b8322.append(" SafeStuff"); // append some safe content
		b8322.replace(b8322.length()-"Chars".length(),b8322.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8322 = new java.util.HashMap<String,Object>();
		map8322.put("key8322", b8322.toString()); // put in a collection
		String c8322 = (String)map8322.get("key8322"); // get it back out
		String d8322 = c8322.substring(0,c8322.length()-1); // extract most of it
		String e8322 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8322.getBytes() ) )); // B64 encode and decode it
		String f8322 = e8322.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f8322); // reflection
	
		return bar;	
	}
}
