package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18266")
public class BenchmarkTest18266 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35527 = param; //assign
		StringBuilder b35527 = new StringBuilder(a35527);  // stick in stringbuilder
		b35527.append(" SafeStuff"); // append some safe content
		b35527.replace(b35527.length()-"Chars".length(),b35527.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35527 = new java.util.HashMap<String,Object>();
		map35527.put("key35527", b35527.toString()); // put in a collection
		String c35527 = (String)map35527.get("key35527"); // get it back out
		String d35527 = c35527.substring(0,c35527.length()-1); // extract most of it
		String e35527 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35527.getBytes() ) )); // B64 encode and decode it
		String f35527 = e35527.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35527); // reflection
	
		return bar;	
	}
}
