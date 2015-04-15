package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17901")
public class BenchmarkTest17901 extends HttpServlet {
	
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
		String a30992 = param; //assign
		StringBuilder b30992 = new StringBuilder(a30992);  // stick in stringbuilder
		b30992.append(" SafeStuff"); // append some safe content
		b30992.replace(b30992.length()-"Chars".length(),b30992.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30992 = new java.util.HashMap<String,Object>();
		map30992.put("key30992", b30992.toString()); // put in a collection
		String c30992 = (String)map30992.get("key30992"); // get it back out
		String d30992 = c30992.substring(0,c30992.length()-1); // extract most of it
		String e30992 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30992.getBytes() ) )); // B64 encode and decode it
		String f30992 = e30992.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30992); // reflection
	
		return bar;	
	}
}
