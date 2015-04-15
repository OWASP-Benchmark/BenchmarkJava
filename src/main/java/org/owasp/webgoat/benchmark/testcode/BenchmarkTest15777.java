package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15777")
public class BenchmarkTest15777 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97958 = param; //assign
		StringBuilder b97958 = new StringBuilder(a97958);  // stick in stringbuilder
		b97958.append(" SafeStuff"); // append some safe content
		b97958.replace(b97958.length()-"Chars".length(),b97958.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97958 = new java.util.HashMap<String,Object>();
		map97958.put("key97958", b97958.toString()); // put in a collection
		String c97958 = (String)map97958.get("key97958"); // get it back out
		String d97958 = c97958.substring(0,c97958.length()-1); // extract most of it
		String e97958 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97958.getBytes() ) )); // B64 encode and decode it
		String f97958 = e97958.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g97958 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97958); // reflection
	
		return bar;	
	}
}
