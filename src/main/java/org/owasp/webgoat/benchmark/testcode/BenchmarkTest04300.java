package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04300")
public class BenchmarkTest04300 extends HttpServlet {
	
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
		String a95632 = param; //assign
		StringBuilder b95632 = new StringBuilder(a95632);  // stick in stringbuilder
		b95632.append(" SafeStuff"); // append some safe content
		b95632.replace(b95632.length()-"Chars".length(),b95632.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95632 = new java.util.HashMap<String,Object>();
		map95632.put("key95632", b95632.toString()); // put in a collection
		String c95632 = (String)map95632.get("key95632"); // get it back out
		String d95632 = c95632.substring(0,c95632.length()-1); // extract most of it
		String e95632 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95632.getBytes() ) )); // B64 encode and decode it
		String f95632 = e95632.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95632); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
