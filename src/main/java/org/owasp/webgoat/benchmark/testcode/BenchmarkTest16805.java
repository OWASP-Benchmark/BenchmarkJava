package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16805")
public class BenchmarkTest16805 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40610 = param; //assign
		StringBuilder b40610 = new StringBuilder(a40610);  // stick in stringbuilder
		b40610.append(" SafeStuff"); // append some safe content
		b40610.replace(b40610.length()-"Chars".length(),b40610.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40610 = new java.util.HashMap<String,Object>();
		map40610.put("key40610", b40610.toString()); // put in a collection
		String c40610 = (String)map40610.get("key40610"); // get it back out
		String d40610 = c40610.substring(0,c40610.length()-1); // extract most of it
		String e40610 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40610.getBytes() ) )); // B64 encode and decode it
		String f40610 = e40610.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40610); // reflection
	
		return bar;	
	}
}
