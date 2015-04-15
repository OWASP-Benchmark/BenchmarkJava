package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20386")
public class BenchmarkTest20386 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29855 = param; //assign
		StringBuilder b29855 = new StringBuilder(a29855);  // stick in stringbuilder
		b29855.append(" SafeStuff"); // append some safe content
		b29855.replace(b29855.length()-"Chars".length(),b29855.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29855 = new java.util.HashMap<String,Object>();
		map29855.put("key29855", b29855.toString()); // put in a collection
		String c29855 = (String)map29855.get("key29855"); // get it back out
		String d29855 = c29855.substring(0,c29855.length()-1); // extract most of it
		String e29855 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29855.getBytes() ) )); // B64 encode and decode it
		String f29855 = e29855.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29855); // reflection
	
		return bar;	
	}
}
