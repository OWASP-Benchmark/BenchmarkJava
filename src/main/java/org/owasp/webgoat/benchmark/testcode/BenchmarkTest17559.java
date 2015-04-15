package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17559")
public class BenchmarkTest17559 extends HttpServlet {
	
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
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58764 = param; //assign
		StringBuilder b58764 = new StringBuilder(a58764);  // stick in stringbuilder
		b58764.append(" SafeStuff"); // append some safe content
		b58764.replace(b58764.length()-"Chars".length(),b58764.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58764 = new java.util.HashMap<String,Object>();
		map58764.put("key58764", b58764.toString()); // put in a collection
		String c58764 = (String)map58764.get("key58764"); // get it back out
		String d58764 = c58764.substring(0,c58764.length()-1); // extract most of it
		String e58764 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58764.getBytes() ) )); // B64 encode and decode it
		String f58764 = e58764.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58764); // reflection
	
		return bar;	
	}
}
