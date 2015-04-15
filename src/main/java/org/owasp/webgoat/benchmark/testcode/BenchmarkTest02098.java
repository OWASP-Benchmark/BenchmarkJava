package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02098")
public class BenchmarkTest02098 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a59712 = param; //assign
		StringBuilder b59712 = new StringBuilder(a59712);  // stick in stringbuilder
		b59712.append(" SafeStuff"); // append some safe content
		b59712.replace(b59712.length()-"Chars".length(),b59712.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59712 = new java.util.HashMap<String,Object>();
		map59712.put("key59712", b59712.toString()); // put in a collection
		String c59712 = (String)map59712.get("key59712"); // get it back out
		String d59712 = c59712.substring(0,c59712.length()-1); // extract most of it
		String e59712 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59712.getBytes() ) )); // B64 encode and decode it
		String f59712 = e59712.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f59712); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
