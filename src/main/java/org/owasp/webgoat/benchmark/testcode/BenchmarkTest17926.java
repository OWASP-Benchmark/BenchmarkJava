package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17926")
public class BenchmarkTest17926 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a2726 = param; //assign
		StringBuilder b2726 = new StringBuilder(a2726);  // stick in stringbuilder
		b2726.append(" SafeStuff"); // append some safe content
		b2726.replace(b2726.length()-"Chars".length(),b2726.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2726 = new java.util.HashMap<String,Object>();
		map2726.put("key2726", b2726.toString()); // put in a collection
		String c2726 = (String)map2726.get("key2726"); // get it back out
		String d2726 = c2726.substring(0,c2726.length()-1); // extract most of it
		String e2726 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2726.getBytes() ) )); // B64 encode and decode it
		String f2726 = e2726.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g2726 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g2726); // reflection
	
		return bar;	
	}
}
