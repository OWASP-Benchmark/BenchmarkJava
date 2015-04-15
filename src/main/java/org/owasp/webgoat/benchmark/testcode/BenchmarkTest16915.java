package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16915")
public class BenchmarkTest16915 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91041 = param; //assign
		StringBuilder b91041 = new StringBuilder(a91041);  // stick in stringbuilder
		b91041.append(" SafeStuff"); // append some safe content
		b91041.replace(b91041.length()-"Chars".length(),b91041.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91041 = new java.util.HashMap<String,Object>();
		map91041.put("key91041", b91041.toString()); // put in a collection
		String c91041 = (String)map91041.get("key91041"); // get it back out
		String d91041 = c91041.substring(0,c91041.length()-1); // extract most of it
		String e91041 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91041.getBytes() ) )); // B64 encode and decode it
		String f91041 = e91041.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g91041 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91041); // reflection
	
		return bar;	
	}
}
