package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18046")
public class BenchmarkTest18046 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a41647 = param; //assign
		StringBuilder b41647 = new StringBuilder(a41647);  // stick in stringbuilder
		b41647.append(" SafeStuff"); // append some safe content
		b41647.replace(b41647.length()-"Chars".length(),b41647.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41647 = new java.util.HashMap<String,Object>();
		map41647.put("key41647", b41647.toString()); // put in a collection
		String c41647 = (String)map41647.get("key41647"); // get it back out
		String d41647 = c41647.substring(0,c41647.length()-1); // extract most of it
		String e41647 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41647.getBytes() ) )); // B64 encode and decode it
		String f41647 = e41647.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41647); // reflection
	
		return bar;	
	}
}
