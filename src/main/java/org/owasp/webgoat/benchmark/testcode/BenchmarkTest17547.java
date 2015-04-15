package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17547")
public class BenchmarkTest17547 extends HttpServlet {
	
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
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45400 = param; //assign
		StringBuilder b45400 = new StringBuilder(a45400);  // stick in stringbuilder
		b45400.append(" SafeStuff"); // append some safe content
		b45400.replace(b45400.length()-"Chars".length(),b45400.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45400 = new java.util.HashMap<String,Object>();
		map45400.put("key45400", b45400.toString()); // put in a collection
		String c45400 = (String)map45400.get("key45400"); // get it back out
		String d45400 = c45400.substring(0,c45400.length()-1); // extract most of it
		String e45400 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45400.getBytes() ) )); // B64 encode and decode it
		String f45400 = e45400.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45400); // reflection
	
		return bar;	
	}
}
