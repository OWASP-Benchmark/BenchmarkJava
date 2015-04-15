package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12965")
public class BenchmarkTest12965 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52683 = param; //assign
		StringBuilder b52683 = new StringBuilder(a52683);  // stick in stringbuilder
		b52683.append(" SafeStuff"); // append some safe content
		b52683.replace(b52683.length()-"Chars".length(),b52683.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52683 = new java.util.HashMap<String,Object>();
		map52683.put("key52683", b52683.toString()); // put in a collection
		String c52683 = (String)map52683.get("key52683"); // get it back out
		String d52683 = c52683.substring(0,c52683.length()-1); // extract most of it
		String e52683 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52683.getBytes() ) )); // B64 encode and decode it
		String f52683 = e52683.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52683 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52683); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
