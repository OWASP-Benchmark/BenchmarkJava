package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03751")
public class BenchmarkTest03751 extends HttpServlet {
	
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
		String a79634 = param; //assign
		StringBuilder b79634 = new StringBuilder(a79634);  // stick in stringbuilder
		b79634.append(" SafeStuff"); // append some safe content
		b79634.replace(b79634.length()-"Chars".length(),b79634.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79634 = new java.util.HashMap<String,Object>();
		map79634.put("key79634", b79634.toString()); // put in a collection
		String c79634 = (String)map79634.get("key79634"); // get it back out
		String d79634 = c79634.substring(0,c79634.length()-1); // extract most of it
		String e79634 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79634.getBytes() ) )); // B64 encode and decode it
		String f79634 = e79634.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79634); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
