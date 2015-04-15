package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16854")
public class BenchmarkTest16854 extends HttpServlet {
	
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
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8945 = param; //assign
		StringBuilder b8945 = new StringBuilder(a8945);  // stick in stringbuilder
		b8945.append(" SafeStuff"); // append some safe content
		b8945.replace(b8945.length()-"Chars".length(),b8945.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8945 = new java.util.HashMap<String,Object>();
		map8945.put("key8945", b8945.toString()); // put in a collection
		String c8945 = (String)map8945.get("key8945"); // get it back out
		String d8945 = c8945.substring(0,c8945.length()-1); // extract most of it
		String e8945 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8945.getBytes() ) )); // B64 encode and decode it
		String f8945 = e8945.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f8945); // reflection
	
		return bar;	
	}
}
