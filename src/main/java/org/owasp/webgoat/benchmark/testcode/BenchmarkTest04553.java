package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04553")
public class BenchmarkTest04553 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a56969 = param; //assign
		StringBuilder b56969 = new StringBuilder(a56969);  // stick in stringbuilder
		b56969.append(" SafeStuff"); // append some safe content
		b56969.replace(b56969.length()-"Chars".length(),b56969.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56969 = new java.util.HashMap<String,Object>();
		map56969.put("key56969", b56969.toString()); // put in a collection
		String c56969 = (String)map56969.get("key56969"); // get it back out
		String d56969 = c56969.substring(0,c56969.length()-1); // extract most of it
		String e56969 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56969.getBytes() ) )); // B64 encode and decode it
		String f56969 = e56969.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f56969); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
