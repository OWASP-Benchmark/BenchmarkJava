package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04356")
public class BenchmarkTest04356 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a50726 = param; //assign
		StringBuilder b50726 = new StringBuilder(a50726);  // stick in stringbuilder
		b50726.append(" SafeStuff"); // append some safe content
		b50726.replace(b50726.length()-"Chars".length(),b50726.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50726 = new java.util.HashMap<String,Object>();
		map50726.put("key50726", b50726.toString()); // put in a collection
		String c50726 = (String)map50726.get("key50726"); // get it back out
		String d50726 = c50726.substring(0,c50726.length()-1); // extract most of it
		String e50726 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50726.getBytes() ) )); // B64 encode and decode it
		String f50726 = e50726.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50726); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
