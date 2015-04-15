package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17627")
public class BenchmarkTest17627 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a22792 = param; //assign
		StringBuilder b22792 = new StringBuilder(a22792);  // stick in stringbuilder
		b22792.append(" SafeStuff"); // append some safe content
		b22792.replace(b22792.length()-"Chars".length(),b22792.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22792 = new java.util.HashMap<String,Object>();
		map22792.put("key22792", b22792.toString()); // put in a collection
		String c22792 = (String)map22792.get("key22792"); // get it back out
		String d22792 = c22792.substring(0,c22792.length()-1); // extract most of it
		String e22792 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22792.getBytes() ) )); // B64 encode and decode it
		String f22792 = e22792.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f22792); // reflection
	
		return bar;	
	}
}
