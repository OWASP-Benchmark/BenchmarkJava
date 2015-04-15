package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04164")
public class BenchmarkTest04164 extends HttpServlet {
	
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
		String a22754 = param; //assign
		StringBuilder b22754 = new StringBuilder(a22754);  // stick in stringbuilder
		b22754.append(" SafeStuff"); // append some safe content
		b22754.replace(b22754.length()-"Chars".length(),b22754.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22754 = new java.util.HashMap<String,Object>();
		map22754.put("key22754", b22754.toString()); // put in a collection
		String c22754 = (String)map22754.get("key22754"); // get it back out
		String d22754 = c22754.substring(0,c22754.length()-1); // extract most of it
		String e22754 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22754.getBytes() ) )); // B64 encode and decode it
		String f22754 = e22754.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f22754); // reflection
		
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}
}
