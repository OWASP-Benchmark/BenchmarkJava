package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16993")
public class BenchmarkTest16993 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87819 = param; //assign
		StringBuilder b87819 = new StringBuilder(a87819);  // stick in stringbuilder
		b87819.append(" SafeStuff"); // append some safe content
		b87819.replace(b87819.length()-"Chars".length(),b87819.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87819 = new java.util.HashMap<String,Object>();
		map87819.put("key87819", b87819.toString()); // put in a collection
		String c87819 = (String)map87819.get("key87819"); // get it back out
		String d87819 = c87819.substring(0,c87819.length()-1); // extract most of it
		String e87819 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87819.getBytes() ) )); // B64 encode and decode it
		String f87819 = e87819.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87819 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87819); // reflection
	
		return bar;	
	}
}
