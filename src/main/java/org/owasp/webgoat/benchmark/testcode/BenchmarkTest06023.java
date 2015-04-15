package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06023")
public class BenchmarkTest06023 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a30768 = param; //assign
		StringBuilder b30768 = new StringBuilder(a30768);  // stick in stringbuilder
		b30768.append(" SafeStuff"); // append some safe content
		b30768.replace(b30768.length()-"Chars".length(),b30768.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30768 = new java.util.HashMap<String,Object>();
		map30768.put("key30768", b30768.toString()); // put in a collection
		String c30768 = (String)map30768.get("key30768"); // get it back out
		String d30768 = c30768.substring(0,c30768.length()-1); // extract most of it
		String e30768 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30768.getBytes() ) )); // B64 encode and decode it
		String f30768 = e30768.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g30768 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g30768); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
