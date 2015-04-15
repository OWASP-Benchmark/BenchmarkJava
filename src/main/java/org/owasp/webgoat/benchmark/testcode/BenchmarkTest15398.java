package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15398")
public class BenchmarkTest15398 extends HttpServlet {
	
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
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10993 = param; //assign
		StringBuilder b10993 = new StringBuilder(a10993);  // stick in stringbuilder
		b10993.append(" SafeStuff"); // append some safe content
		b10993.replace(b10993.length()-"Chars".length(),b10993.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10993 = new java.util.HashMap<String,Object>();
		map10993.put("key10993", b10993.toString()); // put in a collection
		String c10993 = (String)map10993.get("key10993"); // get it back out
		String d10993 = c10993.substring(0,c10993.length()-1); // extract most of it
		String e10993 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10993.getBytes() ) )); // B64 encode and decode it
		String f10993 = e10993.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10993 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10993); // reflection
	
		return bar;	
	}
}
