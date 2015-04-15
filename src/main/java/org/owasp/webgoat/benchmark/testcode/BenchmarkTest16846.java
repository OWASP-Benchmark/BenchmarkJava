package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16846")
public class BenchmarkTest16846 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73111 = param; //assign
		StringBuilder b73111 = new StringBuilder(a73111);  // stick in stringbuilder
		b73111.append(" SafeStuff"); // append some safe content
		b73111.replace(b73111.length()-"Chars".length(),b73111.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73111 = new java.util.HashMap<String,Object>();
		map73111.put("key73111", b73111.toString()); // put in a collection
		String c73111 = (String)map73111.get("key73111"); // get it back out
		String d73111 = c73111.substring(0,c73111.length()-1); // extract most of it
		String e73111 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73111.getBytes() ) )); // B64 encode and decode it
		String f73111 = e73111.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73111); // reflection
	
		return bar;	
	}
}
