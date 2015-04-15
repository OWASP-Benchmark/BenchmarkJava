package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04902")
public class BenchmarkTest04902 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a21333 = param; //assign
		StringBuilder b21333 = new StringBuilder(a21333);  // stick in stringbuilder
		b21333.append(" SafeStuff"); // append some safe content
		b21333.replace(b21333.length()-"Chars".length(),b21333.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21333 = new java.util.HashMap<String,Object>();
		map21333.put("key21333", b21333.toString()); // put in a collection
		String c21333 = (String)map21333.get("key21333"); // get it back out
		String d21333 = c21333.substring(0,c21333.length()-1); // extract most of it
		String e21333 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21333.getBytes() ) )); // B64 encode and decode it
		String f21333 = e21333.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21333); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}
}
