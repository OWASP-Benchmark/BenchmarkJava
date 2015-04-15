package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01223")
public class BenchmarkTest01223 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a15083 = param; //assign
		StringBuilder b15083 = new StringBuilder(a15083);  // stick in stringbuilder
		b15083.append(" SafeStuff"); // append some safe content
		b15083.replace(b15083.length()-"Chars".length(),b15083.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15083 = new java.util.HashMap<String,Object>();
		map15083.put("key15083", b15083.toString()); // put in a collection
		String c15083 = (String)map15083.get("key15083"); // get it back out
		String d15083 = c15083.substring(0,c15083.length()-1); // extract most of it
		String e15083 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15083.getBytes() ) )); // B64 encode and decode it
		String f15083 = e15083.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15083); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}
}
