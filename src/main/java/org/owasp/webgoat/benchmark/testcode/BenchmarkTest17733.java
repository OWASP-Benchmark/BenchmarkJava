package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17733")
public class BenchmarkTest17733 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a99281 = param; //assign
		StringBuilder b99281 = new StringBuilder(a99281);  // stick in stringbuilder
		b99281.append(" SafeStuff"); // append some safe content
		b99281.replace(b99281.length()-"Chars".length(),b99281.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99281 = new java.util.HashMap<String,Object>();
		map99281.put("key99281", b99281.toString()); // put in a collection
		String c99281 = (String)map99281.get("key99281"); // get it back out
		String d99281 = c99281.substring(0,c99281.length()-1); // extract most of it
		String e99281 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99281.getBytes() ) )); // B64 encode and decode it
		String f99281 = e99281.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f99281); // reflection
	
		return bar;	
	}
}
