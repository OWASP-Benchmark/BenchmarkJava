package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19326")
public class BenchmarkTest19326 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7496 = param; //assign
		StringBuilder b7496 = new StringBuilder(a7496);  // stick in stringbuilder
		b7496.append(" SafeStuff"); // append some safe content
		b7496.replace(b7496.length()-"Chars".length(),b7496.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7496 = new java.util.HashMap<String,Object>();
		map7496.put("key7496", b7496.toString()); // put in a collection
		String c7496 = (String)map7496.get("key7496"); // get it back out
		String d7496 = c7496.substring(0,c7496.length()-1); // extract most of it
		String e7496 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7496.getBytes() ) )); // B64 encode and decode it
		String f7496 = e7496.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f7496); // reflection
	
		return bar;	
	}
}
