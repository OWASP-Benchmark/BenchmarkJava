package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18788")
public class BenchmarkTest18788 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71801 = param; //assign
		StringBuilder b71801 = new StringBuilder(a71801);  // stick in stringbuilder
		b71801.append(" SafeStuff"); // append some safe content
		b71801.replace(b71801.length()-"Chars".length(),b71801.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71801 = new java.util.HashMap<String,Object>();
		map71801.put("key71801", b71801.toString()); // put in a collection
		String c71801 = (String)map71801.get("key71801"); // get it back out
		String d71801 = c71801.substring(0,c71801.length()-1); // extract most of it
		String e71801 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71801.getBytes() ) )); // B64 encode and decode it
		String f71801 = e71801.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71801 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71801); // reflection
	
		return bar;	
	}
}
