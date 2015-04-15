package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19311")
public class BenchmarkTest19311 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62759 = param; //assign
		StringBuilder b62759 = new StringBuilder(a62759);  // stick in stringbuilder
		b62759.append(" SafeStuff"); // append some safe content
		b62759.replace(b62759.length()-"Chars".length(),b62759.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62759 = new java.util.HashMap<String,Object>();
		map62759.put("key62759", b62759.toString()); // put in a collection
		String c62759 = (String)map62759.get("key62759"); // get it back out
		String d62759 = c62759.substring(0,c62759.length()-1); // extract most of it
		String e62759 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62759.getBytes() ) )); // B64 encode and decode it
		String f62759 = e62759.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62759); // reflection
	
		return bar;	
	}
}
