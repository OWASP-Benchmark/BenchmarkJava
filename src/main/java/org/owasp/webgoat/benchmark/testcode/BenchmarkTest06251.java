package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06251")
public class BenchmarkTest06251 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a45873 = param; //assign
		StringBuilder b45873 = new StringBuilder(a45873);  // stick in stringbuilder
		b45873.append(" SafeStuff"); // append some safe content
		b45873.replace(b45873.length()-"Chars".length(),b45873.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45873 = new java.util.HashMap<String,Object>();
		map45873.put("key45873", b45873.toString()); // put in a collection
		String c45873 = (String)map45873.get("key45873"); // get it back out
		String d45873 = c45873.substring(0,c45873.length()-1); // extract most of it
		String e45873 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45873.getBytes() ) )); // B64 encode and decode it
		String f45873 = e45873.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45873 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45873); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}
}
