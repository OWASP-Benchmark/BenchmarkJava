package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01209")
public class BenchmarkTest01209 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a91599 = param; //assign
		StringBuilder b91599 = new StringBuilder(a91599);  // stick in stringbuilder
		b91599.append(" SafeStuff"); // append some safe content
		b91599.replace(b91599.length()-"Chars".length(),b91599.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91599 = new java.util.HashMap<String,Object>();
		map91599.put("key91599", b91599.toString()); // put in a collection
		String c91599 = (String)map91599.get("key91599"); // get it back out
		String d91599 = c91599.substring(0,c91599.length()-1); // extract most of it
		String e91599 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91599.getBytes() ) )); // B64 encode and decode it
		String f91599 = e91599.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91599); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
