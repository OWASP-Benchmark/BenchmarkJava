package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20203")
public class BenchmarkTest20203 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55876 = param; //assign
		StringBuilder b55876 = new StringBuilder(a55876);  // stick in stringbuilder
		b55876.append(" SafeStuff"); // append some safe content
		b55876.replace(b55876.length()-"Chars".length(),b55876.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55876 = new java.util.HashMap<String,Object>();
		map55876.put("key55876", b55876.toString()); // put in a collection
		String c55876 = (String)map55876.get("key55876"); // get it back out
		String d55876 = c55876.substring(0,c55876.length()-1); // extract most of it
		String e55876 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55876.getBytes() ) )); // B64 encode and decode it
		String f55876 = e55876.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55876 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55876); // reflection
	
		return bar;	
	}
}
