package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19178")
public class BenchmarkTest19178 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a2178 = param; //assign
		StringBuilder b2178 = new StringBuilder(a2178);  // stick in stringbuilder
		b2178.append(" SafeStuff"); // append some safe content
		b2178.replace(b2178.length()-"Chars".length(),b2178.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2178 = new java.util.HashMap<String,Object>();
		map2178.put("key2178", b2178.toString()); // put in a collection
		String c2178 = (String)map2178.get("key2178"); // get it back out
		String d2178 = c2178.substring(0,c2178.length()-1); // extract most of it
		String e2178 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2178.getBytes() ) )); // B64 encode and decode it
		String f2178 = e2178.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g2178 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g2178); // reflection
	
		return bar;	
	}
}
