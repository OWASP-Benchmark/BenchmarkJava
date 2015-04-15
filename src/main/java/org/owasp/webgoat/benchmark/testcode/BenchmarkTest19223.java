package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19223")
public class BenchmarkTest19223 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24174 = param; //assign
		StringBuilder b24174 = new StringBuilder(a24174);  // stick in stringbuilder
		b24174.append(" SafeStuff"); // append some safe content
		b24174.replace(b24174.length()-"Chars".length(),b24174.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24174 = new java.util.HashMap<String,Object>();
		map24174.put("key24174", b24174.toString()); // put in a collection
		String c24174 = (String)map24174.get("key24174"); // get it back out
		String d24174 = c24174.substring(0,c24174.length()-1); // extract most of it
		String e24174 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24174.getBytes() ) )); // B64 encode and decode it
		String f24174 = e24174.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24174); // reflection
	
		return bar;	
	}
}
