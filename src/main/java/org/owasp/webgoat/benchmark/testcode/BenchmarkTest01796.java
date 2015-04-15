package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01796")
public class BenchmarkTest01796 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a16072 = param; //assign
		StringBuilder b16072 = new StringBuilder(a16072);  // stick in stringbuilder
		b16072.append(" SafeStuff"); // append some safe content
		b16072.replace(b16072.length()-"Chars".length(),b16072.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16072 = new java.util.HashMap<String,Object>();
		map16072.put("key16072", b16072.toString()); // put in a collection
		String c16072 = (String)map16072.get("key16072"); // get it back out
		String d16072 = c16072.substring(0,c16072.length()-1); // extract most of it
		String e16072 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16072.getBytes() ) )); // B64 encode and decode it
		String f16072 = e16072.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f16072); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
