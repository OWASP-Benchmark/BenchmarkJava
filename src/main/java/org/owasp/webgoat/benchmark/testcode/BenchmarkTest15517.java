package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15517")
public class BenchmarkTest15517 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a22449 = param; //assign
		StringBuilder b22449 = new StringBuilder(a22449);  // stick in stringbuilder
		b22449.append(" SafeStuff"); // append some safe content
		b22449.replace(b22449.length()-"Chars".length(),b22449.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22449 = new java.util.HashMap<String,Object>();
		map22449.put("key22449", b22449.toString()); // put in a collection
		String c22449 = (String)map22449.get("key22449"); // get it back out
		String d22449 = c22449.substring(0,c22449.length()-1); // extract most of it
		String e22449 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22449.getBytes() ) )); // B64 encode and decode it
		String f22449 = e22449.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g22449 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g22449); // reflection
	
		return bar;	
	}
}
