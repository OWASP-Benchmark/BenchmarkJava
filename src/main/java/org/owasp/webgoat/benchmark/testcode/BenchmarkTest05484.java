package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05484")
public class BenchmarkTest05484 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a59541 = param; //assign
		StringBuilder b59541 = new StringBuilder(a59541);  // stick in stringbuilder
		b59541.append(" SafeStuff"); // append some safe content
		b59541.replace(b59541.length()-"Chars".length(),b59541.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59541 = new java.util.HashMap<String,Object>();
		map59541.put("key59541", b59541.toString()); // put in a collection
		String c59541 = (String)map59541.get("key59541"); // get it back out
		String d59541 = c59541.substring(0,c59541.length()-1); // extract most of it
		String e59541 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59541.getBytes() ) )); // B64 encode and decode it
		String f59541 = e59541.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g59541 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59541); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
