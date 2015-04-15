package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06470")
public class BenchmarkTest06470 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a79606 = param; //assign
		StringBuilder b79606 = new StringBuilder(a79606);  // stick in stringbuilder
		b79606.append(" SafeStuff"); // append some safe content
		b79606.replace(b79606.length()-"Chars".length(),b79606.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79606 = new java.util.HashMap<String,Object>();
		map79606.put("key79606", b79606.toString()); // put in a collection
		String c79606 = (String)map79606.get("key79606"); // get it back out
		String d79606 = c79606.substring(0,c79606.length()-1); // extract most of it
		String e79606 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79606.getBytes() ) )); // B64 encode and decode it
		String f79606 = e79606.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g79606 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g79606); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
