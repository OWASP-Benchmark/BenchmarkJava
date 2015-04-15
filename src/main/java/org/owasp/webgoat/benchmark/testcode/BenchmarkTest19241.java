package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19241")
public class BenchmarkTest19241 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51455 = param; //assign
		StringBuilder b51455 = new StringBuilder(a51455);  // stick in stringbuilder
		b51455.append(" SafeStuff"); // append some safe content
		b51455.replace(b51455.length()-"Chars".length(),b51455.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51455 = new java.util.HashMap<String,Object>();
		map51455.put("key51455", b51455.toString()); // put in a collection
		String c51455 = (String)map51455.get("key51455"); // get it back out
		String d51455 = c51455.substring(0,c51455.length()-1); // extract most of it
		String e51455 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51455.getBytes() ) )); // B64 encode and decode it
		String f51455 = e51455.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51455); // reflection
	
		return bar;	
	}
}
