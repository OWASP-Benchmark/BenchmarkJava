package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17439")
public class BenchmarkTest17439 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44221 = param; //assign
		StringBuilder b44221 = new StringBuilder(a44221);  // stick in stringbuilder
		b44221.append(" SafeStuff"); // append some safe content
		b44221.replace(b44221.length()-"Chars".length(),b44221.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44221 = new java.util.HashMap<String,Object>();
		map44221.put("key44221", b44221.toString()); // put in a collection
		String c44221 = (String)map44221.get("key44221"); // get it back out
		String d44221 = c44221.substring(0,c44221.length()-1); // extract most of it
		String e44221 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44221.getBytes() ) )); // B64 encode and decode it
		String f44221 = e44221.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44221); // reflection
	
		return bar;	
	}
}
