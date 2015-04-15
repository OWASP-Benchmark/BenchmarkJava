package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03901")
public class BenchmarkTest03901 extends HttpServlet {
	
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
		
		
		
		// Chain a bunch of propagators in sequence
		String a45616 = param; //assign
		StringBuilder b45616 = new StringBuilder(a45616);  // stick in stringbuilder
		b45616.append(" SafeStuff"); // append some safe content
		b45616.replace(b45616.length()-"Chars".length(),b45616.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45616 = new java.util.HashMap<String,Object>();
		map45616.put("key45616", b45616.toString()); // put in a collection
		String c45616 = (String)map45616.get("key45616"); // get it back out
		String d45616 = c45616.substring(0,c45616.length()-1); // extract most of it
		String e45616 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45616.getBytes() ) )); // B64 encode and decode it
		String f45616 = e45616.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45616); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
