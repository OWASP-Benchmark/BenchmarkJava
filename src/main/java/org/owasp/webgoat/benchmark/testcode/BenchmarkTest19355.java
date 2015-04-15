package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19355")
public class BenchmarkTest19355 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a56072 = param; //assign
		StringBuilder b56072 = new StringBuilder(a56072);  // stick in stringbuilder
		b56072.append(" SafeStuff"); // append some safe content
		b56072.replace(b56072.length()-"Chars".length(),b56072.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56072 = new java.util.HashMap<String,Object>();
		map56072.put("key56072", b56072.toString()); // put in a collection
		String c56072 = (String)map56072.get("key56072"); // get it back out
		String d56072 = c56072.substring(0,c56072.length()-1); // extract most of it
		String e56072 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56072.getBytes() ) )); // B64 encode and decode it
		String f56072 = e56072.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g56072 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g56072); // reflection
	
		return bar;	
	}
}
