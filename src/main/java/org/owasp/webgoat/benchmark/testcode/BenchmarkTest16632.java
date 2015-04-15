package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16632")
public class BenchmarkTest16632 extends HttpServlet {
	
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
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a17923 = param; //assign
		StringBuilder b17923 = new StringBuilder(a17923);  // stick in stringbuilder
		b17923.append(" SafeStuff"); // append some safe content
		b17923.replace(b17923.length()-"Chars".length(),b17923.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17923 = new java.util.HashMap<String,Object>();
		map17923.put("key17923", b17923.toString()); // put in a collection
		String c17923 = (String)map17923.get("key17923"); // get it back out
		String d17923 = c17923.substring(0,c17923.length()-1); // extract most of it
		String e17923 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17923.getBytes() ) )); // B64 encode and decode it
		String f17923 = e17923.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f17923); // reflection
	
		return bar;	
	}
}
