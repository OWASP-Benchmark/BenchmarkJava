package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16997")
public class BenchmarkTest16997 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71766 = param; //assign
		StringBuilder b71766 = new StringBuilder(a71766);  // stick in stringbuilder
		b71766.append(" SafeStuff"); // append some safe content
		b71766.replace(b71766.length()-"Chars".length(),b71766.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71766 = new java.util.HashMap<String,Object>();
		map71766.put("key71766", b71766.toString()); // put in a collection
		String c71766 = (String)map71766.get("key71766"); // get it back out
		String d71766 = c71766.substring(0,c71766.length()-1); // extract most of it
		String e71766 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71766.getBytes() ) )); // B64 encode and decode it
		String f71766 = e71766.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71766); // reflection
	
		return bar;	
	}
}
