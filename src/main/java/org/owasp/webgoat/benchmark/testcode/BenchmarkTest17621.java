package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17621")
public class BenchmarkTest17621 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62526 = param; //assign
		StringBuilder b62526 = new StringBuilder(a62526);  // stick in stringbuilder
		b62526.append(" SafeStuff"); // append some safe content
		b62526.replace(b62526.length()-"Chars".length(),b62526.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62526 = new java.util.HashMap<String,Object>();
		map62526.put("key62526", b62526.toString()); // put in a collection
		String c62526 = (String)map62526.get("key62526"); // get it back out
		String d62526 = c62526.substring(0,c62526.length()-1); // extract most of it
		String e62526 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62526.getBytes() ) )); // B64 encode and decode it
		String f62526 = e62526.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62526); // reflection
	
		return bar;	
	}
}
