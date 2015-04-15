package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18929")
public class BenchmarkTest18929 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29191 = param; //assign
		StringBuilder b29191 = new StringBuilder(a29191);  // stick in stringbuilder
		b29191.append(" SafeStuff"); // append some safe content
		b29191.replace(b29191.length()-"Chars".length(),b29191.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29191 = new java.util.HashMap<String,Object>();
		map29191.put("key29191", b29191.toString()); // put in a collection
		String c29191 = (String)map29191.get("key29191"); // get it back out
		String d29191 = c29191.substring(0,c29191.length()-1); // extract most of it
		String e29191 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29191.getBytes() ) )); // B64 encode and decode it
		String f29191 = e29191.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g29191 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g29191); // reflection
	
		return bar;	
	}
}
