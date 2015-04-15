package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14988")
public class BenchmarkTest14988 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10911 = param; //assign
		StringBuilder b10911 = new StringBuilder(a10911);  // stick in stringbuilder
		b10911.append(" SafeStuff"); // append some safe content
		b10911.replace(b10911.length()-"Chars".length(),b10911.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10911 = new java.util.HashMap<String,Object>();
		map10911.put("key10911", b10911.toString()); // put in a collection
		String c10911 = (String)map10911.get("key10911"); // get it back out
		String d10911 = c10911.substring(0,c10911.length()-1); // extract most of it
		String e10911 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10911.getBytes() ) )); // B64 encode and decode it
		String f10911 = e10911.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10911 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10911); // reflection
	
		return bar;	
	}
}
