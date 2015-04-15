package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19214")
public class BenchmarkTest19214 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68770 = param; //assign
		StringBuilder b68770 = new StringBuilder(a68770);  // stick in stringbuilder
		b68770.append(" SafeStuff"); // append some safe content
		b68770.replace(b68770.length()-"Chars".length(),b68770.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68770 = new java.util.HashMap<String,Object>();
		map68770.put("key68770", b68770.toString()); // put in a collection
		String c68770 = (String)map68770.get("key68770"); // get it back out
		String d68770 = c68770.substring(0,c68770.length()-1); // extract most of it
		String e68770 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68770.getBytes() ) )); // B64 encode and decode it
		String f68770 = e68770.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g68770 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g68770); // reflection
	
		return bar;	
	}
}
