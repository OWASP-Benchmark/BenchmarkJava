package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19376")
public class BenchmarkTest19376 extends HttpServlet {
	
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
		response.getWriter().println(obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21338 = param; //assign
		StringBuilder b21338 = new StringBuilder(a21338);  // stick in stringbuilder
		b21338.append(" SafeStuff"); // append some safe content
		b21338.replace(b21338.length()-"Chars".length(),b21338.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21338 = new java.util.HashMap<String,Object>();
		map21338.put("key21338", b21338.toString()); // put in a collection
		String c21338 = (String)map21338.get("key21338"); // get it back out
		String d21338 = c21338.substring(0,c21338.length()-1); // extract most of it
		String e21338 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21338.getBytes() ) )); // B64 encode and decode it
		String f21338 = e21338.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g21338 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21338); // reflection
	
		return bar;	
	}
}
