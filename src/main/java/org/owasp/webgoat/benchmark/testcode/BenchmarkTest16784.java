package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16784")
public class BenchmarkTest16784 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73229 = param; //assign
		StringBuilder b73229 = new StringBuilder(a73229);  // stick in stringbuilder
		b73229.append(" SafeStuff"); // append some safe content
		b73229.replace(b73229.length()-"Chars".length(),b73229.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73229 = new java.util.HashMap<String,Object>();
		map73229.put("key73229", b73229.toString()); // put in a collection
		String c73229 = (String)map73229.get("key73229"); // get it back out
		String d73229 = c73229.substring(0,c73229.length()-1); // extract most of it
		String e73229 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73229.getBytes() ) )); // B64 encode and decode it
		String f73229 = e73229.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73229 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73229); // reflection
	
		return bar;	
	}
}
