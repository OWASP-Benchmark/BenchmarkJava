package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19610")
public class BenchmarkTest19610 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21598 = param; //assign
		StringBuilder b21598 = new StringBuilder(a21598);  // stick in stringbuilder
		b21598.append(" SafeStuff"); // append some safe content
		b21598.replace(b21598.length()-"Chars".length(),b21598.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21598 = new java.util.HashMap<String,Object>();
		map21598.put("key21598", b21598.toString()); // put in a collection
		String c21598 = (String)map21598.get("key21598"); // get it back out
		String d21598 = c21598.substring(0,c21598.length()-1); // extract most of it
		String e21598 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21598.getBytes() ) )); // B64 encode and decode it
		String f21598 = e21598.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g21598 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21598); // reflection
	
		return bar;	
	}
}
