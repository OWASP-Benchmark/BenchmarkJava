package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19997")
public class BenchmarkTest19997 extends HttpServlet {
	
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
		String a42273 = param; //assign
		StringBuilder b42273 = new StringBuilder(a42273);  // stick in stringbuilder
		b42273.append(" SafeStuff"); // append some safe content
		b42273.replace(b42273.length()-"Chars".length(),b42273.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map42273 = new java.util.HashMap<String,Object>();
		map42273.put("key42273", b42273.toString()); // put in a collection
		String c42273 = (String)map42273.get("key42273"); // get it back out
		String d42273 = c42273.substring(0,c42273.length()-1); // extract most of it
		String e42273 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d42273.getBytes() ) )); // B64 encode and decode it
		String f42273 = e42273.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f42273); // reflection
	
		return bar;	
	}
}
