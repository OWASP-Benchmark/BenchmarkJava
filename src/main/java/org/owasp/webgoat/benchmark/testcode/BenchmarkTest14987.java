package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14987")
public class BenchmarkTest14987 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a41431 = param; //assign
		StringBuilder b41431 = new StringBuilder(a41431);  // stick in stringbuilder
		b41431.append(" SafeStuff"); // append some safe content
		b41431.replace(b41431.length()-"Chars".length(),b41431.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41431 = new java.util.HashMap<String,Object>();
		map41431.put("key41431", b41431.toString()); // put in a collection
		String c41431 = (String)map41431.get("key41431"); // get it back out
		String d41431 = c41431.substring(0,c41431.length()-1); // extract most of it
		String e41431 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41431.getBytes() ) )); // B64 encode and decode it
		String f41431 = e41431.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41431); // reflection
	
		return bar;	
	}
}
