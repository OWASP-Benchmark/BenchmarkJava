package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16876")
public class BenchmarkTest16876 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79991 = param; //assign
		StringBuilder b79991 = new StringBuilder(a79991);  // stick in stringbuilder
		b79991.append(" SafeStuff"); // append some safe content
		b79991.replace(b79991.length()-"Chars".length(),b79991.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79991 = new java.util.HashMap<String,Object>();
		map79991.put("key79991", b79991.toString()); // put in a collection
		String c79991 = (String)map79991.get("key79991"); // get it back out
		String d79991 = c79991.substring(0,c79991.length()-1); // extract most of it
		String e79991 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79991.getBytes() ) )); // B64 encode and decode it
		String f79991 = e79991.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79991); // reflection
	
		return bar;	
	}
}
