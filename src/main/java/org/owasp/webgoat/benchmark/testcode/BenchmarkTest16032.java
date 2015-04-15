package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16032")
public class BenchmarkTest16032 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10251 = param; //assign
		StringBuilder b10251 = new StringBuilder(a10251);  // stick in stringbuilder
		b10251.append(" SafeStuff"); // append some safe content
		b10251.replace(b10251.length()-"Chars".length(),b10251.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10251 = new java.util.HashMap<String,Object>();
		map10251.put("key10251", b10251.toString()); // put in a collection
		String c10251 = (String)map10251.get("key10251"); // get it back out
		String d10251 = c10251.substring(0,c10251.length()-1); // extract most of it
		String e10251 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10251.getBytes() ) )); // B64 encode and decode it
		String f10251 = e10251.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10251); // reflection
	
		return bar;	
	}
}
