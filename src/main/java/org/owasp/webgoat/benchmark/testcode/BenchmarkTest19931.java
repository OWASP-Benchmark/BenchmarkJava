package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19931")
public class BenchmarkTest19931 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87605 = param; //assign
		StringBuilder b87605 = new StringBuilder(a87605);  // stick in stringbuilder
		b87605.append(" SafeStuff"); // append some safe content
		b87605.replace(b87605.length()-"Chars".length(),b87605.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87605 = new java.util.HashMap<String,Object>();
		map87605.put("key87605", b87605.toString()); // put in a collection
		String c87605 = (String)map87605.get("key87605"); // get it back out
		String d87605 = c87605.substring(0,c87605.length()-1); // extract most of it
		String e87605 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87605.getBytes() ) )); // B64 encode and decode it
		String f87605 = e87605.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87605 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87605); // reflection
	
		return bar;	
	}
}
