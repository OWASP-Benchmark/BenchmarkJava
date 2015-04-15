package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17904")
public class BenchmarkTest17904 extends HttpServlet {
	
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
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11233 = param; //assign
		StringBuilder b11233 = new StringBuilder(a11233);  // stick in stringbuilder
		b11233.append(" SafeStuff"); // append some safe content
		b11233.replace(b11233.length()-"Chars".length(),b11233.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11233 = new java.util.HashMap<String,Object>();
		map11233.put("key11233", b11233.toString()); // put in a collection
		String c11233 = (String)map11233.get("key11233"); // get it back out
		String d11233 = c11233.substring(0,c11233.length()-1); // extract most of it
		String e11233 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11233.getBytes() ) )); // B64 encode and decode it
		String f11233 = e11233.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g11233 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11233); // reflection
	
		return bar;	
	}
}
