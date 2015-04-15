package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03356")
public class BenchmarkTest03356 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a87947 = param; //assign
		StringBuilder b87947 = new StringBuilder(a87947);  // stick in stringbuilder
		b87947.append(" SafeStuff"); // append some safe content
		b87947.replace(b87947.length()-"Chars".length(),b87947.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87947 = new java.util.HashMap<String,Object>();
		map87947.put("key87947", b87947.toString()); // put in a collection
		String c87947 = (String)map87947.get("key87947"); // get it back out
		String d87947 = c87947.substring(0,c87947.length()-1); // extract most of it
		String e87947 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87947.getBytes() ) )); // B64 encode and decode it
		String f87947 = e87947.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87947 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87947); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
