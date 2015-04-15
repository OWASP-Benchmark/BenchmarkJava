package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20000")
public class BenchmarkTest20000 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85105 = param; //assign
		StringBuilder b85105 = new StringBuilder(a85105);  // stick in stringbuilder
		b85105.append(" SafeStuff"); // append some safe content
		b85105.replace(b85105.length()-"Chars".length(),b85105.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85105 = new java.util.HashMap<String,Object>();
		map85105.put("key85105", b85105.toString()); // put in a collection
		String c85105 = (String)map85105.get("key85105"); // get it back out
		String d85105 = c85105.substring(0,c85105.length()-1); // extract most of it
		String e85105 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85105.getBytes() ) )); // B64 encode and decode it
		String f85105 = e85105.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g85105 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g85105); // reflection
	
		return bar;	
	}
}
