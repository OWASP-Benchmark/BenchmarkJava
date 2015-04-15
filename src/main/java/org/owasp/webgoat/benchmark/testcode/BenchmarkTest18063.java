package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18063")
public class BenchmarkTest18063 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95624 = param; //assign
		StringBuilder b95624 = new StringBuilder(a95624);  // stick in stringbuilder
		b95624.append(" SafeStuff"); // append some safe content
		b95624.replace(b95624.length()-"Chars".length(),b95624.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95624 = new java.util.HashMap<String,Object>();
		map95624.put("key95624", b95624.toString()); // put in a collection
		String c95624 = (String)map95624.get("key95624"); // get it back out
		String d95624 = c95624.substring(0,c95624.length()-1); // extract most of it
		String e95624 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95624.getBytes() ) )); // B64 encode and decode it
		String f95624 = e95624.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95624); // reflection
	
		return bar;	
	}
}
