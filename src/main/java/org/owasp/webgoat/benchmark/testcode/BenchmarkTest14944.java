package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14944")
public class BenchmarkTest14944 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77970 = param; //assign
		StringBuilder b77970 = new StringBuilder(a77970);  // stick in stringbuilder
		b77970.append(" SafeStuff"); // append some safe content
		b77970.replace(b77970.length()-"Chars".length(),b77970.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77970 = new java.util.HashMap<String,Object>();
		map77970.put("key77970", b77970.toString()); // put in a collection
		String c77970 = (String)map77970.get("key77970"); // get it back out
		String d77970 = c77970.substring(0,c77970.length()-1); // extract most of it
		String e77970 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77970.getBytes() ) )); // B64 encode and decode it
		String f77970 = e77970.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g77970 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77970); // reflection
	
		return bar;	
	}
}
