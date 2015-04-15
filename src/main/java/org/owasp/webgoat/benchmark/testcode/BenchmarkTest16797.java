package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16797")
public class BenchmarkTest16797 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30271 = param; //assign
		StringBuilder b30271 = new StringBuilder(a30271);  // stick in stringbuilder
		b30271.append(" SafeStuff"); // append some safe content
		b30271.replace(b30271.length()-"Chars".length(),b30271.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30271 = new java.util.HashMap<String,Object>();
		map30271.put("key30271", b30271.toString()); // put in a collection
		String c30271 = (String)map30271.get("key30271"); // get it back out
		String d30271 = c30271.substring(0,c30271.length()-1); // extract most of it
		String e30271 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30271.getBytes() ) )); // B64 encode and decode it
		String f30271 = e30271.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30271); // reflection
	
		return bar;	
	}
}
