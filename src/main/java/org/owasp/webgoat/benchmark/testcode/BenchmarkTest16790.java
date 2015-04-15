package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16790")
public class BenchmarkTest16790 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a84761 = param; //assign
		StringBuilder b84761 = new StringBuilder(a84761);  // stick in stringbuilder
		b84761.append(" SafeStuff"); // append some safe content
		b84761.replace(b84761.length()-"Chars".length(),b84761.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84761 = new java.util.HashMap<String,Object>();
		map84761.put("key84761", b84761.toString()); // put in a collection
		String c84761 = (String)map84761.get("key84761"); // get it back out
		String d84761 = c84761.substring(0,c84761.length()-1); // extract most of it
		String e84761 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84761.getBytes() ) )); // B64 encode and decode it
		String f84761 = e84761.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84761 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84761); // reflection
	
		return bar;	
	}
}
