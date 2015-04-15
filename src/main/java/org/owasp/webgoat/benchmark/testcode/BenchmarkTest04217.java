package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04217")
public class BenchmarkTest04217 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a78925 = param; //assign
		StringBuilder b78925 = new StringBuilder(a78925);  // stick in stringbuilder
		b78925.append(" SafeStuff"); // append some safe content
		b78925.replace(b78925.length()-"Chars".length(),b78925.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78925 = new java.util.HashMap<String,Object>();
		map78925.put("key78925", b78925.toString()); // put in a collection
		String c78925 = (String)map78925.get("key78925"); // get it back out
		String d78925 = c78925.substring(0,c78925.length()-1); // extract most of it
		String e78925 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78925.getBytes() ) )); // B64 encode and decode it
		String f78925 = e78925.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g78925 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78925); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
