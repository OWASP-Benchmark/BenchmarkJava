package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17336")
public class BenchmarkTest17336 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a74785 = param; //assign
		StringBuilder b74785 = new StringBuilder(a74785);  // stick in stringbuilder
		b74785.append(" SafeStuff"); // append some safe content
		b74785.replace(b74785.length()-"Chars".length(),b74785.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map74785 = new java.util.HashMap<String,Object>();
		map74785.put("key74785", b74785.toString()); // put in a collection
		String c74785 = (String)map74785.get("key74785"); // get it back out
		String d74785 = c74785.substring(0,c74785.length()-1); // extract most of it
		String e74785 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d74785.getBytes() ) )); // B64 encode and decode it
		String f74785 = e74785.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f74785); // reflection
	
		return bar;	
	}
}
