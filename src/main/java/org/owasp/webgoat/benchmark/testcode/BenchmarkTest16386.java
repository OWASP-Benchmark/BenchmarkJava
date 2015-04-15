package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16386")
public class BenchmarkTest16386 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34226 = param; //assign
		StringBuilder b34226 = new StringBuilder(a34226);  // stick in stringbuilder
		b34226.append(" SafeStuff"); // append some safe content
		b34226.replace(b34226.length()-"Chars".length(),b34226.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34226 = new java.util.HashMap<String,Object>();
		map34226.put("key34226", b34226.toString()); // put in a collection
		String c34226 = (String)map34226.get("key34226"); // get it back out
		String d34226 = c34226.substring(0,c34226.length()-1); // extract most of it
		String e34226 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34226.getBytes() ) )); // B64 encode and decode it
		String f34226 = e34226.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34226); // reflection
	
		return bar;	
	}
}
