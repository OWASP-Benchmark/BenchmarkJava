package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18561")
public class BenchmarkTest18561 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45763 = param; //assign
		StringBuilder b45763 = new StringBuilder(a45763);  // stick in stringbuilder
		b45763.append(" SafeStuff"); // append some safe content
		b45763.replace(b45763.length()-"Chars".length(),b45763.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45763 = new java.util.HashMap<String,Object>();
		map45763.put("key45763", b45763.toString()); // put in a collection
		String c45763 = (String)map45763.get("key45763"); // get it back out
		String d45763 = c45763.substring(0,c45763.length()-1); // extract most of it
		String e45763 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45763.getBytes() ) )); // B64 encode and decode it
		String f45763 = e45763.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45763 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45763); // reflection
	
		return bar;	
	}
}
