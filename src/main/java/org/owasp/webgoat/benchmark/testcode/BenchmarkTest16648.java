package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16648")
public class BenchmarkTest16648 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30655 = param; //assign
		StringBuilder b30655 = new StringBuilder(a30655);  // stick in stringbuilder
		b30655.append(" SafeStuff"); // append some safe content
		b30655.replace(b30655.length()-"Chars".length(),b30655.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30655 = new java.util.HashMap<String,Object>();
		map30655.put("key30655", b30655.toString()); // put in a collection
		String c30655 = (String)map30655.get("key30655"); // get it back out
		String d30655 = c30655.substring(0,c30655.length()-1); // extract most of it
		String e30655 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30655.getBytes() ) )); // B64 encode and decode it
		String f30655 = e30655.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30655); // reflection
	
		return bar;	
	}
}
