package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19955")
public class BenchmarkTest19955 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46005 = param; //assign
		StringBuilder b46005 = new StringBuilder(a46005);  // stick in stringbuilder
		b46005.append(" SafeStuff"); // append some safe content
		b46005.replace(b46005.length()-"Chars".length(),b46005.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46005 = new java.util.HashMap<String,Object>();
		map46005.put("key46005", b46005.toString()); // put in a collection
		String c46005 = (String)map46005.get("key46005"); // get it back out
		String d46005 = c46005.substring(0,c46005.length()-1); // extract most of it
		String e46005 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46005.getBytes() ) )); // B64 encode and decode it
		String f46005 = e46005.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f46005); // reflection
	
		return bar;	
	}
}
