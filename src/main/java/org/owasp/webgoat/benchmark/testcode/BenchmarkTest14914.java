package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14914")
public class BenchmarkTest14914 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a84776 = param; //assign
		StringBuilder b84776 = new StringBuilder(a84776);  // stick in stringbuilder
		b84776.append(" SafeStuff"); // append some safe content
		b84776.replace(b84776.length()-"Chars".length(),b84776.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84776 = new java.util.HashMap<String,Object>();
		map84776.put("key84776", b84776.toString()); // put in a collection
		String c84776 = (String)map84776.get("key84776"); // get it back out
		String d84776 = c84776.substring(0,c84776.length()-1); // extract most of it
		String e84776 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84776.getBytes() ) )); // B64 encode and decode it
		String f84776 = e84776.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84776 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84776); // reflection
	
		return bar;	
	}
}
