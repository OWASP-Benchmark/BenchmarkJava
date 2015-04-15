package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17458")
public class BenchmarkTest17458 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a63934 = param; //assign
		StringBuilder b63934 = new StringBuilder(a63934);  // stick in stringbuilder
		b63934.append(" SafeStuff"); // append some safe content
		b63934.replace(b63934.length()-"Chars".length(),b63934.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63934 = new java.util.HashMap<String,Object>();
		map63934.put("key63934", b63934.toString()); // put in a collection
		String c63934 = (String)map63934.get("key63934"); // get it back out
		String d63934 = c63934.substring(0,c63934.length()-1); // extract most of it
		String e63934 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63934.getBytes() ) )); // B64 encode and decode it
		String f63934 = e63934.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63934); // reflection
	
		return bar;	
	}
}
