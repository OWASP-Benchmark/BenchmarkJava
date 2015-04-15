package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19974")
public class BenchmarkTest19974 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86531 = param; //assign
		StringBuilder b86531 = new StringBuilder(a86531);  // stick in stringbuilder
		b86531.append(" SafeStuff"); // append some safe content
		b86531.replace(b86531.length()-"Chars".length(),b86531.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86531 = new java.util.HashMap<String,Object>();
		map86531.put("key86531", b86531.toString()); // put in a collection
		String c86531 = (String)map86531.get("key86531"); // get it back out
		String d86531 = c86531.substring(0,c86531.length()-1); // extract most of it
		String e86531 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86531.getBytes() ) )); // B64 encode and decode it
		String f86531 = e86531.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86531 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86531); // reflection
	
		return bar;	
	}
}
