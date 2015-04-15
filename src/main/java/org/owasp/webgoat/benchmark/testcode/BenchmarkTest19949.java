package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19949")
public class BenchmarkTest19949 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a65068 = param; //assign
		StringBuilder b65068 = new StringBuilder(a65068);  // stick in stringbuilder
		b65068.append(" SafeStuff"); // append some safe content
		b65068.replace(b65068.length()-"Chars".length(),b65068.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65068 = new java.util.HashMap<String,Object>();
		map65068.put("key65068", b65068.toString()); // put in a collection
		String c65068 = (String)map65068.get("key65068"); // get it back out
		String d65068 = c65068.substring(0,c65068.length()-1); // extract most of it
		String e65068 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65068.getBytes() ) )); // B64 encode and decode it
		String f65068 = e65068.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g65068 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g65068); // reflection
	
		return bar;	
	}
}
