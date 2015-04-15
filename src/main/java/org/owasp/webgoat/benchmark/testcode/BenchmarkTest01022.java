package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01022")
public class BenchmarkTest01022 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a75076 = param; //assign
		StringBuilder b75076 = new StringBuilder(a75076);  // stick in stringbuilder
		b75076.append(" SafeStuff"); // append some safe content
		b75076.replace(b75076.length()-"Chars".length(),b75076.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75076 = new java.util.HashMap<String,Object>();
		map75076.put("key75076", b75076.toString()); // put in a collection
		String c75076 = (String)map75076.get("key75076"); // get it back out
		String d75076 = c75076.substring(0,c75076.length()-1); // extract most of it
		String e75076 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75076.getBytes() ) )); // B64 encode and decode it
		String f75076 = e75076.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g75076 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75076); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
