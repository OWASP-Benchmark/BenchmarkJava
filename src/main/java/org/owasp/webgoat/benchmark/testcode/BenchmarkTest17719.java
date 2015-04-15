package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17719")
public class BenchmarkTest17719 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46128 = param; //assign
		StringBuilder b46128 = new StringBuilder(a46128);  // stick in stringbuilder
		b46128.append(" SafeStuff"); // append some safe content
		b46128.replace(b46128.length()-"Chars".length(),b46128.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46128 = new java.util.HashMap<String,Object>();
		map46128.put("key46128", b46128.toString()); // put in a collection
		String c46128 = (String)map46128.get("key46128"); // get it back out
		String d46128 = c46128.substring(0,c46128.length()-1); // extract most of it
		String e46128 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46128.getBytes() ) )); // B64 encode and decode it
		String f46128 = e46128.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f46128); // reflection
	
		return bar;	
	}
}
