package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03531")
public class BenchmarkTest03531 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a10099 = param; //assign
		StringBuilder b10099 = new StringBuilder(a10099);  // stick in stringbuilder
		b10099.append(" SafeStuff"); // append some safe content
		b10099.replace(b10099.length()-"Chars".length(),b10099.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10099 = new java.util.HashMap<String,Object>();
		map10099.put("key10099", b10099.toString()); // put in a collection
		String c10099 = (String)map10099.get("key10099"); // get it back out
		String d10099 = c10099.substring(0,c10099.length()-1); // extract most of it
		String e10099 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10099.getBytes() ) )); // B64 encode and decode it
		String f10099 = e10099.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g10099 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g10099); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
