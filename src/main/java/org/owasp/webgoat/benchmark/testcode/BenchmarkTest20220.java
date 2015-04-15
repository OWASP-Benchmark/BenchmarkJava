package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20220")
public class BenchmarkTest20220 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31107 = param; //assign
		StringBuilder b31107 = new StringBuilder(a31107);  // stick in stringbuilder
		b31107.append(" SafeStuff"); // append some safe content
		b31107.replace(b31107.length()-"Chars".length(),b31107.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31107 = new java.util.HashMap<String,Object>();
		map31107.put("key31107", b31107.toString()); // put in a collection
		String c31107 = (String)map31107.get("key31107"); // get it back out
		String d31107 = c31107.substring(0,c31107.length()-1); // extract most of it
		String e31107 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31107.getBytes() ) )); // B64 encode and decode it
		String f31107 = e31107.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31107); // reflection
	
		return bar;	
	}
}
