package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16826")
public class BenchmarkTest16826 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76433 = param; //assign
		StringBuilder b76433 = new StringBuilder(a76433);  // stick in stringbuilder
		b76433.append(" SafeStuff"); // append some safe content
		b76433.replace(b76433.length()-"Chars".length(),b76433.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76433 = new java.util.HashMap<String,Object>();
		map76433.put("key76433", b76433.toString()); // put in a collection
		String c76433 = (String)map76433.get("key76433"); // get it back out
		String d76433 = c76433.substring(0,c76433.length()-1); // extract most of it
		String e76433 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76433.getBytes() ) )); // B64 encode and decode it
		String f76433 = e76433.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76433); // reflection
	
		return bar;	
	}
}
