package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18081")
public class BenchmarkTest18081 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34134 = param; //assign
		StringBuilder b34134 = new StringBuilder(a34134);  // stick in stringbuilder
		b34134.append(" SafeStuff"); // append some safe content
		b34134.replace(b34134.length()-"Chars".length(),b34134.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34134 = new java.util.HashMap<String,Object>();
		map34134.put("key34134", b34134.toString()); // put in a collection
		String c34134 = (String)map34134.get("key34134"); // get it back out
		String d34134 = c34134.substring(0,c34134.length()-1); // extract most of it
		String e34134 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34134.getBytes() ) )); // B64 encode and decode it
		String f34134 = e34134.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34134); // reflection
	
		return bar;	
	}
}
