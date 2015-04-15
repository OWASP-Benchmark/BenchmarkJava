package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19243")
public class BenchmarkTest19243 extends HttpServlet {
	
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
		String a48075 = param; //assign
		StringBuilder b48075 = new StringBuilder(a48075);  // stick in stringbuilder
		b48075.append(" SafeStuff"); // append some safe content
		b48075.replace(b48075.length()-"Chars".length(),b48075.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48075 = new java.util.HashMap<String,Object>();
		map48075.put("key48075", b48075.toString()); // put in a collection
		String c48075 = (String)map48075.get("key48075"); // get it back out
		String d48075 = c48075.substring(0,c48075.length()-1); // extract most of it
		String e48075 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48075.getBytes() ) )); // B64 encode and decode it
		String f48075 = e48075.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g48075 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g48075); // reflection
	
		return bar;	
	}
}
