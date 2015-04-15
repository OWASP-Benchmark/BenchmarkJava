package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19005")
public class BenchmarkTest19005 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70954 = param; //assign
		StringBuilder b70954 = new StringBuilder(a70954);  // stick in stringbuilder
		b70954.append(" SafeStuff"); // append some safe content
		b70954.replace(b70954.length()-"Chars".length(),b70954.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70954 = new java.util.HashMap<String,Object>();
		map70954.put("key70954", b70954.toString()); // put in a collection
		String c70954 = (String)map70954.get("key70954"); // get it back out
		String d70954 = c70954.substring(0,c70954.length()-1); // extract most of it
		String e70954 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70954.getBytes() ) )); // B64 encode and decode it
		String f70954 = e70954.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70954); // reflection
	
		return bar;	
	}
}
