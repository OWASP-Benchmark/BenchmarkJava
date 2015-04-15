package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16702")
public class BenchmarkTest16702 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19119 = param; //assign
		StringBuilder b19119 = new StringBuilder(a19119);  // stick in stringbuilder
		b19119.append(" SafeStuff"); // append some safe content
		b19119.replace(b19119.length()-"Chars".length(),b19119.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19119 = new java.util.HashMap<String,Object>();
		map19119.put("key19119", b19119.toString()); // put in a collection
		String c19119 = (String)map19119.get("key19119"); // get it back out
		String d19119 = c19119.substring(0,c19119.length()-1); // extract most of it
		String e19119 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19119.getBytes() ) )); // B64 encode and decode it
		String f19119 = e19119.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19119 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19119); // reflection
	
		return bar;	
	}
}
