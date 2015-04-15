package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19236")
public class BenchmarkTest19236 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6763 = param; //assign
		StringBuilder b6763 = new StringBuilder(a6763);  // stick in stringbuilder
		b6763.append(" SafeStuff"); // append some safe content
		b6763.replace(b6763.length()-"Chars".length(),b6763.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6763 = new java.util.HashMap<String,Object>();
		map6763.put("key6763", b6763.toString()); // put in a collection
		String c6763 = (String)map6763.get("key6763"); // get it back out
		String d6763 = c6763.substring(0,c6763.length()-1); // extract most of it
		String e6763 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6763.getBytes() ) )); // B64 encode and decode it
		String f6763 = e6763.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6763); // reflection
	
		return bar;	
	}
}
