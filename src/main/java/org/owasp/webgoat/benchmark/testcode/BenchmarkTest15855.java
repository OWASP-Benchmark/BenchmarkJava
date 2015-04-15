package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15855")
public class BenchmarkTest15855 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31030 = param; //assign
		StringBuilder b31030 = new StringBuilder(a31030);  // stick in stringbuilder
		b31030.append(" SafeStuff"); // append some safe content
		b31030.replace(b31030.length()-"Chars".length(),b31030.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31030 = new java.util.HashMap<String,Object>();
		map31030.put("key31030", b31030.toString()); // put in a collection
		String c31030 = (String)map31030.get("key31030"); // get it back out
		String d31030 = c31030.substring(0,c31030.length()-1); // extract most of it
		String e31030 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31030.getBytes() ) )); // B64 encode and decode it
		String f31030 = e31030.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31030); // reflection
	
		return bar;	
	}
}
