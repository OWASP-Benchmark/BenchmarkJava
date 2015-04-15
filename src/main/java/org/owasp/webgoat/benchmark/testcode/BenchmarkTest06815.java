package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06815")
public class BenchmarkTest06815 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a91839 = param; //assign
		StringBuilder b91839 = new StringBuilder(a91839);  // stick in stringbuilder
		b91839.append(" SafeStuff"); // append some safe content
		b91839.replace(b91839.length()-"Chars".length(),b91839.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91839 = new java.util.HashMap<String,Object>();
		map91839.put("key91839", b91839.toString()); // put in a collection
		String c91839 = (String)map91839.get("key91839"); // get it back out
		String d91839 = c91839.substring(0,c91839.length()-1); // extract most of it
		String e91839 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91839.getBytes() ) )); // B64 encode and decode it
		String f91839 = e91839.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g91839 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91839); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
