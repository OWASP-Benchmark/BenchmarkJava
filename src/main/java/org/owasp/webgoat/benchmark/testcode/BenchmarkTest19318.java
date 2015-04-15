package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19318")
public class BenchmarkTest19318 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40742 = param; //assign
		StringBuilder b40742 = new StringBuilder(a40742);  // stick in stringbuilder
		b40742.append(" SafeStuff"); // append some safe content
		b40742.replace(b40742.length()-"Chars".length(),b40742.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40742 = new java.util.HashMap<String,Object>();
		map40742.put("key40742", b40742.toString()); // put in a collection
		String c40742 = (String)map40742.get("key40742"); // get it back out
		String d40742 = c40742.substring(0,c40742.length()-1); // extract most of it
		String e40742 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40742.getBytes() ) )); // B64 encode and decode it
		String f40742 = e40742.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g40742 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g40742); // reflection
	
		return bar;	
	}
}
