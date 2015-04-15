package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08475")
public class BenchmarkTest08475 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

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
		String a44578 = param; //assign
		StringBuilder b44578 = new StringBuilder(a44578);  // stick in stringbuilder
		b44578.append(" SafeStuff"); // append some safe content
		b44578.replace(b44578.length()-"Chars".length(),b44578.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44578 = new java.util.HashMap<String,Object>();
		map44578.put("key44578", b44578.toString()); // put in a collection
		String c44578 = (String)map44578.get("key44578"); // get it back out
		String d44578 = c44578.substring(0,c44578.length()-1); // extract most of it
		String e44578 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44578.getBytes() ) )); // B64 encode and decode it
		String f44578 = e44578.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44578); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
