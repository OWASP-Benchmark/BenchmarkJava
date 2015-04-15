package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09721")
public class BenchmarkTest09721 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a85216 = param; //assign
		StringBuilder b85216 = new StringBuilder(a85216);  // stick in stringbuilder
		b85216.append(" SafeStuff"); // append some safe content
		b85216.replace(b85216.length()-"Chars".length(),b85216.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85216 = new java.util.HashMap<String,Object>();
		map85216.put("key85216", b85216.toString()); // put in a collection
		String c85216 = (String)map85216.get("key85216"); // get it back out
		String d85216 = c85216.substring(0,c85216.length()-1); // extract most of it
		String e85216 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85216.getBytes() ) )); // B64 encode and decode it
		String f85216 = e85216.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85216); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
