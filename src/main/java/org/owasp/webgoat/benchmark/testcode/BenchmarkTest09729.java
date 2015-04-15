package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09729")
public class BenchmarkTest09729 extends HttpServlet {
	
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
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15422 = param; //assign
		StringBuilder b15422 = new StringBuilder(a15422);  // stick in stringbuilder
		b15422.append(" SafeStuff"); // append some safe content
		b15422.replace(b15422.length()-"Chars".length(),b15422.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15422 = new java.util.HashMap<String,Object>();
		map15422.put("key15422", b15422.toString()); // put in a collection
		String c15422 = (String)map15422.get("key15422"); // get it back out
		String d15422 = c15422.substring(0,c15422.length()-1); // extract most of it
		String e15422 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15422.getBytes() ) )); // B64 encode and decode it
		String f15422 = e15422.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15422); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
