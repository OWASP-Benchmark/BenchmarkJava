package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03371")
public class BenchmarkTest03371 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a55696 = param; //assign
		StringBuilder b55696 = new StringBuilder(a55696);  // stick in stringbuilder
		b55696.append(" SafeStuff"); // append some safe content
		b55696.replace(b55696.length()-"Chars".length(),b55696.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55696 = new java.util.HashMap<String,Object>();
		map55696.put("key55696", b55696.toString()); // put in a collection
		String c55696 = (String)map55696.get("key55696"); // get it back out
		String d55696 = c55696.substring(0,c55696.length()-1); // extract most of it
		String e55696 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55696.getBytes() ) )); // B64 encode and decode it
		String f55696 = e55696.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55696 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55696); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
