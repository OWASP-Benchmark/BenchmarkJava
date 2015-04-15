package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16868")
public class BenchmarkTest16868 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35419 = param; //assign
		StringBuilder b35419 = new StringBuilder(a35419);  // stick in stringbuilder
		b35419.append(" SafeStuff"); // append some safe content
		b35419.replace(b35419.length()-"Chars".length(),b35419.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35419 = new java.util.HashMap<String,Object>();
		map35419.put("key35419", b35419.toString()); // put in a collection
		String c35419 = (String)map35419.get("key35419"); // get it back out
		String d35419 = c35419.substring(0,c35419.length()-1); // extract most of it
		String e35419 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35419.getBytes() ) )); // B64 encode and decode it
		String f35419 = e35419.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35419); // reflection
	
		return bar;	
	}
}
