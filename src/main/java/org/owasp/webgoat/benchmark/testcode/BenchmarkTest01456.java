package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01456")
public class BenchmarkTest01456 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a23654 = param; //assign
		StringBuilder b23654 = new StringBuilder(a23654);  // stick in stringbuilder
		b23654.append(" SafeStuff"); // append some safe content
		b23654.replace(b23654.length()-"Chars".length(),b23654.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23654 = new java.util.HashMap<String,Object>();
		map23654.put("key23654", b23654.toString()); // put in a collection
		String c23654 = (String)map23654.get("key23654"); // get it back out
		String d23654 = c23654.substring(0,c23654.length()-1); // extract most of it
		String e23654 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23654.getBytes() ) )); // B64 encode and decode it
		String f23654 = e23654.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g23654 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g23654); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
