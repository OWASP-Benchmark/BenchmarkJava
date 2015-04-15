package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13459")
public class BenchmarkTest13459 extends HttpServlet {
	
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
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85006 = param; //assign
		StringBuilder b85006 = new StringBuilder(a85006);  // stick in stringbuilder
		b85006.append(" SafeStuff"); // append some safe content
		b85006.replace(b85006.length()-"Chars".length(),b85006.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85006 = new java.util.HashMap<String,Object>();
		map85006.put("key85006", b85006.toString()); // put in a collection
		String c85006 = (String)map85006.get("key85006"); // get it back out
		String d85006 = c85006.substring(0,c85006.length()-1); // extract most of it
		String e85006 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85006.getBytes() ) )); // B64 encode and decode it
		String f85006 = e85006.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85006); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
