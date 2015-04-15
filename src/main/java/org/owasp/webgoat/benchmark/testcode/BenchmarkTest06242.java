package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06242")
public class BenchmarkTest06242 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a85974 = param; //assign
		StringBuilder b85974 = new StringBuilder(a85974);  // stick in stringbuilder
		b85974.append(" SafeStuff"); // append some safe content
		b85974.replace(b85974.length()-"Chars".length(),b85974.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85974 = new java.util.HashMap<String,Object>();
		map85974.put("key85974", b85974.toString()); // put in a collection
		String c85974 = (String)map85974.get("key85974"); // get it back out
		String d85974 = c85974.substring(0,c85974.length()-1); // extract most of it
		String e85974 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85974.getBytes() ) )); // B64 encode and decode it
		String f85974 = e85974.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85974); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
