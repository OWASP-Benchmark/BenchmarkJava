package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03720")
public class BenchmarkTest03720 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a62634 = param; //assign
		StringBuilder b62634 = new StringBuilder(a62634);  // stick in stringbuilder
		b62634.append(" SafeStuff"); // append some safe content
		b62634.replace(b62634.length()-"Chars".length(),b62634.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62634 = new java.util.HashMap<String,Object>();
		map62634.put("key62634", b62634.toString()); // put in a collection
		String c62634 = (String)map62634.get("key62634"); // get it back out
		String d62634 = c62634.substring(0,c62634.length()-1); // extract most of it
		String e62634 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62634.getBytes() ) )); // B64 encode and decode it
		String f62634 = e62634.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62634); // reflection
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
