package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01443")
public class BenchmarkTest01443 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a20055 = param; //assign
		StringBuilder b20055 = new StringBuilder(a20055);  // stick in stringbuilder
		b20055.append(" SafeStuff"); // append some safe content
		b20055.replace(b20055.length()-"Chars".length(),b20055.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20055 = new java.util.HashMap<String,Object>();
		map20055.put("key20055", b20055.toString()); // put in a collection
		String c20055 = (String)map20055.get("key20055"); // get it back out
		String d20055 = c20055.substring(0,c20055.length()-1); // extract most of it
		String e20055 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20055.getBytes() ) )); // B64 encode and decode it
		String f20055 = e20055.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g20055 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g20055); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}
}
