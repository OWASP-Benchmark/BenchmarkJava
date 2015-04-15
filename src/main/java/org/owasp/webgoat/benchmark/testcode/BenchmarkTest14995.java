package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14995")
public class BenchmarkTest14995 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91510 = param; //assign
		StringBuilder b91510 = new StringBuilder(a91510);  // stick in stringbuilder
		b91510.append(" SafeStuff"); // append some safe content
		b91510.replace(b91510.length()-"Chars".length(),b91510.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91510 = new java.util.HashMap<String,Object>();
		map91510.put("key91510", b91510.toString()); // put in a collection
		String c91510 = (String)map91510.get("key91510"); // get it back out
		String d91510 = c91510.substring(0,c91510.length()-1); // extract most of it
		String e91510 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91510.getBytes() ) )); // B64 encode and decode it
		String f91510 = e91510.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91510); // reflection
	
		return bar;	
	}
}
