package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19936")
public class BenchmarkTest19936 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27057 = param; //assign
		StringBuilder b27057 = new StringBuilder(a27057);  // stick in stringbuilder
		b27057.append(" SafeStuff"); // append some safe content
		b27057.replace(b27057.length()-"Chars".length(),b27057.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27057 = new java.util.HashMap<String,Object>();
		map27057.put("key27057", b27057.toString()); // put in a collection
		String c27057 = (String)map27057.get("key27057"); // get it back out
		String d27057 = c27057.substring(0,c27057.length()-1); // extract most of it
		String e27057 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27057.getBytes() ) )); // B64 encode and decode it
		String f27057 = e27057.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27057); // reflection
	
		return bar;	
	}
}
