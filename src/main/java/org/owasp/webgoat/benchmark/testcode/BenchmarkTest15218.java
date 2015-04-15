package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15218")
public class BenchmarkTest15218 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a81421 = param; //assign
		StringBuilder b81421 = new StringBuilder(a81421);  // stick in stringbuilder
		b81421.append(" SafeStuff"); // append some safe content
		b81421.replace(b81421.length()-"Chars".length(),b81421.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81421 = new java.util.HashMap<String,Object>();
		map81421.put("key81421", b81421.toString()); // put in a collection
		String c81421 = (String)map81421.get("key81421"); // get it back out
		String d81421 = c81421.substring(0,c81421.length()-1); // extract most of it
		String e81421 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81421.getBytes() ) )); // B64 encode and decode it
		String f81421 = e81421.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81421); // reflection
	
		return bar;	
	}
}
