package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09833")
public class BenchmarkTest09833 extends HttpServlet {
	
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
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7751 = param; //assign
		StringBuilder b7751 = new StringBuilder(a7751);  // stick in stringbuilder
		b7751.append(" SafeStuff"); // append some safe content
		b7751.replace(b7751.length()-"Chars".length(),b7751.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7751 = new java.util.HashMap<String,Object>();
		map7751.put("key7751", b7751.toString()); // put in a collection
		String c7751 = (String)map7751.get("key7751"); // get it back out
		String d7751 = c7751.substring(0,c7751.length()-1); // extract most of it
		String e7751 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7751.getBytes() ) )); // B64 encode and decode it
		String f7751 = e7751.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g7751 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g7751); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
