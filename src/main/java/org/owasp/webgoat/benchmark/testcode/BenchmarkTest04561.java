package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04561")
public class BenchmarkTest04561 extends HttpServlet {
	
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
		String a85177 = param; //assign
		StringBuilder b85177 = new StringBuilder(a85177);  // stick in stringbuilder
		b85177.append(" SafeStuff"); // append some safe content
		b85177.replace(b85177.length()-"Chars".length(),b85177.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85177 = new java.util.HashMap<String,Object>();
		map85177.put("key85177", b85177.toString()); // put in a collection
		String c85177 = (String)map85177.get("key85177"); // get it back out
		String d85177 = c85177.substring(0,c85177.length()-1); // extract most of it
		String e85177 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85177.getBytes() ) )); // B64 encode and decode it
		String f85177 = e85177.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85177); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}
}
