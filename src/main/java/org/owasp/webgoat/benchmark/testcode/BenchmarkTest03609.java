package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03609")
public class BenchmarkTest03609 extends HttpServlet {
	
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
		String a56828 = param; //assign
		StringBuilder b56828 = new StringBuilder(a56828);  // stick in stringbuilder
		b56828.append(" SafeStuff"); // append some safe content
		b56828.replace(b56828.length()-"Chars".length(),b56828.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56828 = new java.util.HashMap<String,Object>();
		map56828.put("key56828", b56828.toString()); // put in a collection
		String c56828 = (String)map56828.get("key56828"); // get it back out
		String d56828 = c56828.substring(0,c56828.length()-1); // extract most of it
		String e56828 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56828.getBytes() ) )); // B64 encode and decode it
		String f56828 = e56828.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f56828); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
