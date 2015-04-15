package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02992")
public class BenchmarkTest02992 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a35695 = param; //assign
		StringBuilder b35695 = new StringBuilder(a35695);  // stick in stringbuilder
		b35695.append(" SafeStuff"); // append some safe content
		b35695.replace(b35695.length()-"Chars".length(),b35695.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35695 = new java.util.HashMap<String,Object>();
		map35695.put("key35695", b35695.toString()); // put in a collection
		String c35695 = (String)map35695.get("key35695"); // get it back out
		String d35695 = c35695.substring(0,c35695.length()-1); // extract most of it
		String e35695 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35695.getBytes() ) )); // B64 encode and decode it
		String f35695 = e35695.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35695 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35695); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}
}
