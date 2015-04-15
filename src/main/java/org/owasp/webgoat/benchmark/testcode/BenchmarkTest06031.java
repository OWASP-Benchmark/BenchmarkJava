package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06031")
public class BenchmarkTest06031 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a9673 = param; //assign
		StringBuilder b9673 = new StringBuilder(a9673);  // stick in stringbuilder
		b9673.append(" SafeStuff"); // append some safe content
		b9673.replace(b9673.length()-"Chars".length(),b9673.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9673 = new java.util.HashMap<String,Object>();
		map9673.put("key9673", b9673.toString()); // put in a collection
		String c9673 = (String)map9673.get("key9673"); // get it back out
		String d9673 = c9673.substring(0,c9673.length()-1); // extract most of it
		String e9673 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9673.getBytes() ) )); // B64 encode and decode it
		String f9673 = e9673.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9673); // reflection
		
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}
}
