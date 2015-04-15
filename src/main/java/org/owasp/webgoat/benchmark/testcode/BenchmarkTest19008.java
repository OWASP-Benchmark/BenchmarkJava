package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19008")
public class BenchmarkTest19008 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10742 = param; //assign
		StringBuilder b10742 = new StringBuilder(a10742);  // stick in stringbuilder
		b10742.append(" SafeStuff"); // append some safe content
		b10742.replace(b10742.length()-"Chars".length(),b10742.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10742 = new java.util.HashMap<String,Object>();
		map10742.put("key10742", b10742.toString()); // put in a collection
		String c10742 = (String)map10742.get("key10742"); // get it back out
		String d10742 = c10742.substring(0,c10742.length()-1); // extract most of it
		String e10742 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10742.getBytes() ) )); // B64 encode and decode it
		String f10742 = e10742.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10742 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10742); // reflection
	
		return bar;	
	}
}
