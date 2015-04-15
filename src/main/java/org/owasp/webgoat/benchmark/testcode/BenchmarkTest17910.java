package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17910")
public class BenchmarkTest17910 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a2585 = param; //assign
		StringBuilder b2585 = new StringBuilder(a2585);  // stick in stringbuilder
		b2585.append(" SafeStuff"); // append some safe content
		b2585.replace(b2585.length()-"Chars".length(),b2585.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2585 = new java.util.HashMap<String,Object>();
		map2585.put("key2585", b2585.toString()); // put in a collection
		String c2585 = (String)map2585.get("key2585"); // get it back out
		String d2585 = c2585.substring(0,c2585.length()-1); // extract most of it
		String e2585 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2585.getBytes() ) )); // B64 encode and decode it
		String f2585 = e2585.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f2585); // reflection
	
		return bar;	
	}
}
