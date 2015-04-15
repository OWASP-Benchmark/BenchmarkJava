package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03631")
public class BenchmarkTest03631 extends HttpServlet {
	
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
		String a3954 = param; //assign
		StringBuilder b3954 = new StringBuilder(a3954);  // stick in stringbuilder
		b3954.append(" SafeStuff"); // append some safe content
		b3954.replace(b3954.length()-"Chars".length(),b3954.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3954 = new java.util.HashMap<String,Object>();
		map3954.put("key3954", b3954.toString()); // put in a collection
		String c3954 = (String)map3954.get("key3954"); // get it back out
		String d3954 = c3954.substring(0,c3954.length()-1); // extract most of it
		String e3954 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3954.getBytes() ) )); // B64 encode and decode it
		String f3954 = e3954.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3954); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}
}
