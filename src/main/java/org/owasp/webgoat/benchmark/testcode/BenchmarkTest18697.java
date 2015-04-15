package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18697")
public class BenchmarkTest18697 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37846 = param; //assign
		StringBuilder b37846 = new StringBuilder(a37846);  // stick in stringbuilder
		b37846.append(" SafeStuff"); // append some safe content
		b37846.replace(b37846.length()-"Chars".length(),b37846.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37846 = new java.util.HashMap<String,Object>();
		map37846.put("key37846", b37846.toString()); // put in a collection
		String c37846 = (String)map37846.get("key37846"); // get it back out
		String d37846 = c37846.substring(0,c37846.length()-1); // extract most of it
		String e37846 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37846.getBytes() ) )); // B64 encode and decode it
		String f37846 = e37846.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37846 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37846); // reflection
	
		return bar;	
	}
}
