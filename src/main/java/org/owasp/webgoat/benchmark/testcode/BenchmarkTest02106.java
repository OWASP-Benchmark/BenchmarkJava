package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02106")
public class BenchmarkTest02106 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a90753 = param; //assign
		StringBuilder b90753 = new StringBuilder(a90753);  // stick in stringbuilder
		b90753.append(" SafeStuff"); // append some safe content
		b90753.replace(b90753.length()-"Chars".length(),b90753.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90753 = new java.util.HashMap<String,Object>();
		map90753.put("key90753", b90753.toString()); // put in a collection
		String c90753 = (String)map90753.get("key90753"); // get it back out
		String d90753 = c90753.substring(0,c90753.length()-1); // extract most of it
		String e90753 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90753.getBytes() ) )); // B64 encode and decode it
		String f90753 = e90753.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g90753 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g90753); // reflection
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}
}
