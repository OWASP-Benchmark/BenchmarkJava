package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16636")
public class BenchmarkTest16636 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a6865 = param; //assign
		StringBuilder b6865 = new StringBuilder(a6865);  // stick in stringbuilder
		b6865.append(" SafeStuff"); // append some safe content
		b6865.replace(b6865.length()-"Chars".length(),b6865.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6865 = new java.util.HashMap<String,Object>();
		map6865.put("key6865", b6865.toString()); // put in a collection
		String c6865 = (String)map6865.get("key6865"); // get it back out
		String d6865 = c6865.substring(0,c6865.length()-1); // extract most of it
		String e6865 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6865.getBytes() ) )); // B64 encode and decode it
		String f6865 = e6865.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6865); // reflection
	
		return bar;	
	}
}
