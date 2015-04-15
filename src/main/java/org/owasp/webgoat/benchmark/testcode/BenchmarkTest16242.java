package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16242")
public class BenchmarkTest16242 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36514 = param; //assign
		StringBuilder b36514 = new StringBuilder(a36514);  // stick in stringbuilder
		b36514.append(" SafeStuff"); // append some safe content
		b36514.replace(b36514.length()-"Chars".length(),b36514.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36514 = new java.util.HashMap<String,Object>();
		map36514.put("key36514", b36514.toString()); // put in a collection
		String c36514 = (String)map36514.get("key36514"); // get it back out
		String d36514 = c36514.substring(0,c36514.length()-1); // extract most of it
		String e36514 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36514.getBytes() ) )); // B64 encode and decode it
		String f36514 = e36514.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f36514); // reflection
	
		return bar;	
	}
}
