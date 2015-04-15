package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18350")
public class BenchmarkTest18350 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64908 = param; //assign
		StringBuilder b64908 = new StringBuilder(a64908);  // stick in stringbuilder
		b64908.append(" SafeStuff"); // append some safe content
		b64908.replace(b64908.length()-"Chars".length(),b64908.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64908 = new java.util.HashMap<String,Object>();
		map64908.put("key64908", b64908.toString()); // put in a collection
		String c64908 = (String)map64908.get("key64908"); // get it back out
		String d64908 = c64908.substring(0,c64908.length()-1); // extract most of it
		String e64908 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64908.getBytes() ) )); // B64 encode and decode it
		String f64908 = e64908.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64908 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64908); // reflection
	
		return bar;	
	}
}
