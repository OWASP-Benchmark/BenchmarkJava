package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16720")
public class BenchmarkTest16720 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23169 = param; //assign
		StringBuilder b23169 = new StringBuilder(a23169);  // stick in stringbuilder
		b23169.append(" SafeStuff"); // append some safe content
		b23169.replace(b23169.length()-"Chars".length(),b23169.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23169 = new java.util.HashMap<String,Object>();
		map23169.put("key23169", b23169.toString()); // put in a collection
		String c23169 = (String)map23169.get("key23169"); // get it back out
		String d23169 = c23169.substring(0,c23169.length()-1); // extract most of it
		String e23169 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23169.getBytes() ) )); // B64 encode and decode it
		String f23169 = e23169.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23169 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23169); // reflection
	
		return bar;	
	}
}
