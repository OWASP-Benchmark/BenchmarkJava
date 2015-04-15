package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16094")
public class BenchmarkTest16094 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47995 = param; //assign
		StringBuilder b47995 = new StringBuilder(a47995);  // stick in stringbuilder
		b47995.append(" SafeStuff"); // append some safe content
		b47995.replace(b47995.length()-"Chars".length(),b47995.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47995 = new java.util.HashMap<String,Object>();
		map47995.put("key47995", b47995.toString()); // put in a collection
		String c47995 = (String)map47995.get("key47995"); // get it back out
		String d47995 = c47995.substring(0,c47995.length()-1); // extract most of it
		String e47995 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47995.getBytes() ) )); // B64 encode and decode it
		String f47995 = e47995.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g47995 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47995); // reflection
	
		return bar;	
	}
}
