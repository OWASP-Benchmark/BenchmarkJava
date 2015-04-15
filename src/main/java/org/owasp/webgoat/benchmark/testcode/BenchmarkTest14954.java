package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14954")
public class BenchmarkTest14954 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8221 = param; //assign
		StringBuilder b8221 = new StringBuilder(a8221);  // stick in stringbuilder
		b8221.append(" SafeStuff"); // append some safe content
		b8221.replace(b8221.length()-"Chars".length(),b8221.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8221 = new java.util.HashMap<String,Object>();
		map8221.put("key8221", b8221.toString()); // put in a collection
		String c8221 = (String)map8221.get("key8221"); // get it back out
		String d8221 = c8221.substring(0,c8221.length()-1); // extract most of it
		String e8221 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8221.getBytes() ) )); // B64 encode and decode it
		String f8221 = e8221.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f8221); // reflection
	
		return bar;	
	}
}
