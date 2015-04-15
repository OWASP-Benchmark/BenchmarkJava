package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19986")
public class BenchmarkTest19986 extends HttpServlet {
	
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
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62755 = param; //assign
		StringBuilder b62755 = new StringBuilder(a62755);  // stick in stringbuilder
		b62755.append(" SafeStuff"); // append some safe content
		b62755.replace(b62755.length()-"Chars".length(),b62755.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62755 = new java.util.HashMap<String,Object>();
		map62755.put("key62755", b62755.toString()); // put in a collection
		String c62755 = (String)map62755.get("key62755"); // get it back out
		String d62755 = c62755.substring(0,c62755.length()-1); // extract most of it
		String e62755 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62755.getBytes() ) )); // B64 encode and decode it
		String f62755 = e62755.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g62755 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g62755); // reflection
	
		return bar;	
	}
}
