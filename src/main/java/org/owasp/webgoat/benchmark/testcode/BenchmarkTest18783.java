package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18783")
public class BenchmarkTest18783 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34971 = param; //assign
		StringBuilder b34971 = new StringBuilder(a34971);  // stick in stringbuilder
		b34971.append(" SafeStuff"); // append some safe content
		b34971.replace(b34971.length()-"Chars".length(),b34971.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34971 = new java.util.HashMap<String,Object>();
		map34971.put("key34971", b34971.toString()); // put in a collection
		String c34971 = (String)map34971.get("key34971"); // get it back out
		String d34971 = c34971.substring(0,c34971.length()-1); // extract most of it
		String e34971 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34971.getBytes() ) )); // B64 encode and decode it
		String f34971 = e34971.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34971); // reflection
	
		return bar;	
	}
}
