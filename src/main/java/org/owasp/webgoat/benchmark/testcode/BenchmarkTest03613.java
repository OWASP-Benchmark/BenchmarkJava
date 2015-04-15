package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03613")
public class BenchmarkTest03613 extends HttpServlet {
	
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
		String a47500 = param; //assign
		StringBuilder b47500 = new StringBuilder(a47500);  // stick in stringbuilder
		b47500.append(" SafeStuff"); // append some safe content
		b47500.replace(b47500.length()-"Chars".length(),b47500.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47500 = new java.util.HashMap<String,Object>();
		map47500.put("key47500", b47500.toString()); // put in a collection
		String c47500 = (String)map47500.get("key47500"); // get it back out
		String d47500 = c47500.substring(0,c47500.length()-1); // extract most of it
		String e47500 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47500.getBytes() ) )); // B64 encode and decode it
		String f47500 = e47500.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47500); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
