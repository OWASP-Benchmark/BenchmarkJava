package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14965")
public class BenchmarkTest14965 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45774 = param; //assign
		StringBuilder b45774 = new StringBuilder(a45774);  // stick in stringbuilder
		b45774.append(" SafeStuff"); // append some safe content
		b45774.replace(b45774.length()-"Chars".length(),b45774.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45774 = new java.util.HashMap<String,Object>();
		map45774.put("key45774", b45774.toString()); // put in a collection
		String c45774 = (String)map45774.get("key45774"); // get it back out
		String d45774 = c45774.substring(0,c45774.length()-1); // extract most of it
		String e45774 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45774.getBytes() ) )); // B64 encode and decode it
		String f45774 = e45774.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45774); // reflection
	
		return bar;	
	}
}
