package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16173")
public class BenchmarkTest16173 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53856 = param; //assign
		StringBuilder b53856 = new StringBuilder(a53856);  // stick in stringbuilder
		b53856.append(" SafeStuff"); // append some safe content
		b53856.replace(b53856.length()-"Chars".length(),b53856.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53856 = new java.util.HashMap<String,Object>();
		map53856.put("key53856", b53856.toString()); // put in a collection
		String c53856 = (String)map53856.get("key53856"); // get it back out
		String d53856 = c53856.substring(0,c53856.length()-1); // extract most of it
		String e53856 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53856.getBytes() ) )); // B64 encode and decode it
		String f53856 = e53856.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g53856 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53856); // reflection
	
		return bar;	
	}
}
