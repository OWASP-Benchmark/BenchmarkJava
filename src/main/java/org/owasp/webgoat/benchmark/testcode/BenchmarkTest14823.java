package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14823")
public class BenchmarkTest14823 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3989 = param; //assign
		StringBuilder b3989 = new StringBuilder(a3989);  // stick in stringbuilder
		b3989.append(" SafeStuff"); // append some safe content
		b3989.replace(b3989.length()-"Chars".length(),b3989.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3989 = new java.util.HashMap<String,Object>();
		map3989.put("key3989", b3989.toString()); // put in a collection
		String c3989 = (String)map3989.get("key3989"); // get it back out
		String d3989 = c3989.substring(0,c3989.length()-1); // extract most of it
		String e3989 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3989.getBytes() ) )); // B64 encode and decode it
		String f3989 = e3989.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g3989 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g3989); // reflection
	
		return bar;	
	}
}
