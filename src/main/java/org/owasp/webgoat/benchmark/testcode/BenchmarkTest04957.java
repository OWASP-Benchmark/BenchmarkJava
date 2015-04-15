package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04957")
public class BenchmarkTest04957 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a93154 = param; //assign
		StringBuilder b93154 = new StringBuilder(a93154);  // stick in stringbuilder
		b93154.append(" SafeStuff"); // append some safe content
		b93154.replace(b93154.length()-"Chars".length(),b93154.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93154 = new java.util.HashMap<String,Object>();
		map93154.put("key93154", b93154.toString()); // put in a collection
		String c93154 = (String)map93154.get("key93154"); // get it back out
		String d93154 = c93154.substring(0,c93154.length()-1); // extract most of it
		String e93154 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93154.getBytes() ) )); // B64 encode and decode it
		String f93154 = e93154.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93154 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93154); // reflection
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
