package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03771")
public class BenchmarkTest03771 extends HttpServlet {
	
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
		String a16323 = param; //assign
		StringBuilder b16323 = new StringBuilder(a16323);  // stick in stringbuilder
		b16323.append(" SafeStuff"); // append some safe content
		b16323.replace(b16323.length()-"Chars".length(),b16323.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map16323 = new java.util.HashMap<String,Object>();
		map16323.put("key16323", b16323.toString()); // put in a collection
		String c16323 = (String)map16323.get("key16323"); // get it back out
		String d16323 = c16323.substring(0,c16323.length()-1); // extract most of it
		String e16323 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d16323.getBytes() ) )); // B64 encode and decode it
		String f16323 = e16323.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g16323 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g16323); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
