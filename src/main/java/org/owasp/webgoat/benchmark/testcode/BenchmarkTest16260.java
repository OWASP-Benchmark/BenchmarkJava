package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16260")
public class BenchmarkTest16260 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11740 = param; //assign
		StringBuilder b11740 = new StringBuilder(a11740);  // stick in stringbuilder
		b11740.append(" SafeStuff"); // append some safe content
		b11740.replace(b11740.length()-"Chars".length(),b11740.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11740 = new java.util.HashMap<String,Object>();
		map11740.put("key11740", b11740.toString()); // put in a collection
		String c11740 = (String)map11740.get("key11740"); // get it back out
		String d11740 = c11740.substring(0,c11740.length()-1); // extract most of it
		String e11740 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11740.getBytes() ) )); // B64 encode and decode it
		String f11740 = e11740.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g11740 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11740); // reflection
	
		return bar;	
	}
}
