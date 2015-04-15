package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04921")
public class BenchmarkTest04921 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a618 = param; //assign
		StringBuilder b618 = new StringBuilder(a618);  // stick in stringbuilder
		b618.append(" SafeStuff"); // append some safe content
		b618.replace(b618.length()-"Chars".length(),b618.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map618 = new java.util.HashMap<String,Object>();
		map618.put("key618", b618.toString()); // put in a collection
		String c618 = (String)map618.get("key618"); // get it back out
		String d618 = c618.substring(0,c618.length()-1); // extract most of it
		String e618 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d618.getBytes() ) )); // B64 encode and decode it
		String f618 = e618.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g618 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g618); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
