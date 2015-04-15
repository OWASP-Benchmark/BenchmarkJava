package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03071")
public class BenchmarkTest03071 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a21891 = param; //assign
		StringBuilder b21891 = new StringBuilder(a21891);  // stick in stringbuilder
		b21891.append(" SafeStuff"); // append some safe content
		b21891.replace(b21891.length()-"Chars".length(),b21891.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21891 = new java.util.HashMap<String,Object>();
		map21891.put("key21891", b21891.toString()); // put in a collection
		String c21891 = (String)map21891.get("key21891"); // get it back out
		String d21891 = c21891.substring(0,c21891.length()-1); // extract most of it
		String e21891 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21891.getBytes() ) )); // B64 encode and decode it
		String f21891 = e21891.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g21891 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21891); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
