package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16775")
public class BenchmarkTest16775 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32474 = param; //assign
		StringBuilder b32474 = new StringBuilder(a32474);  // stick in stringbuilder
		b32474.append(" SafeStuff"); // append some safe content
		b32474.replace(b32474.length()-"Chars".length(),b32474.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32474 = new java.util.HashMap<String,Object>();
		map32474.put("key32474", b32474.toString()); // put in a collection
		String c32474 = (String)map32474.get("key32474"); // get it back out
		String d32474 = c32474.substring(0,c32474.length()-1); // extract most of it
		String e32474 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32474.getBytes() ) )); // B64 encode and decode it
		String f32474 = e32474.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32474); // reflection
	
		return bar;	
	}
}
