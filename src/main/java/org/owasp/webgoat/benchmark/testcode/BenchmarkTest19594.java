package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19594")
public class BenchmarkTest19594 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a96839 = param; //assign
		StringBuilder b96839 = new StringBuilder(a96839);  // stick in stringbuilder
		b96839.append(" SafeStuff"); // append some safe content
		b96839.replace(b96839.length()-"Chars".length(),b96839.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96839 = new java.util.HashMap<String,Object>();
		map96839.put("key96839", b96839.toString()); // put in a collection
		String c96839 = (String)map96839.get("key96839"); // get it back out
		String d96839 = c96839.substring(0,c96839.length()-1); // extract most of it
		String e96839 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96839.getBytes() ) )); // B64 encode and decode it
		String f96839 = e96839.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96839); // reflection
	
		return bar;	
	}
}
