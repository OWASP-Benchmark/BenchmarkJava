package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17006")
public class BenchmarkTest17006 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94734 = param; //assign
		StringBuilder b94734 = new StringBuilder(a94734);  // stick in stringbuilder
		b94734.append(" SafeStuff"); // append some safe content
		b94734.replace(b94734.length()-"Chars".length(),b94734.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94734 = new java.util.HashMap<String,Object>();
		map94734.put("key94734", b94734.toString()); // put in a collection
		String c94734 = (String)map94734.get("key94734"); // get it back out
		String d94734 = c94734.substring(0,c94734.length()-1); // extract most of it
		String e94734 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94734.getBytes() ) )); // B64 encode and decode it
		String f94734 = e94734.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94734); // reflection
	
		return bar;	
	}
}
