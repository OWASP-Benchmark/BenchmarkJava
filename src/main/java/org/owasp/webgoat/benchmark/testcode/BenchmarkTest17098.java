package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17098")
public class BenchmarkTest17098 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5769 = param; //assign
		StringBuilder b5769 = new StringBuilder(a5769);  // stick in stringbuilder
		b5769.append(" SafeStuff"); // append some safe content
		b5769.replace(b5769.length()-"Chars".length(),b5769.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5769 = new java.util.HashMap<String,Object>();
		map5769.put("key5769", b5769.toString()); // put in a collection
		String c5769 = (String)map5769.get("key5769"); // get it back out
		String d5769 = c5769.substring(0,c5769.length()-1); // extract most of it
		String e5769 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5769.getBytes() ) )); // B64 encode and decode it
		String f5769 = e5769.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5769); // reflection
	
		return bar;	
	}
}
