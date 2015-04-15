package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13456")
public class BenchmarkTest13456 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a46948 = param; //assign
		StringBuilder b46948 = new StringBuilder(a46948);  // stick in stringbuilder
		b46948.append(" SafeStuff"); // append some safe content
		b46948.replace(b46948.length()-"Chars".length(),b46948.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46948 = new java.util.HashMap<String,Object>();
		map46948.put("key46948", b46948.toString()); // put in a collection
		String c46948 = (String)map46948.get("key46948"); // get it back out
		String d46948 = c46948.substring(0,c46948.length()-1); // extract most of it
		String e46948 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46948.getBytes() ) )); // B64 encode and decode it
		String f46948 = e46948.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g46948 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g46948); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
