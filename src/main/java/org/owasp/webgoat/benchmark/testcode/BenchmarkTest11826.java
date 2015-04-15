package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11826")
public class BenchmarkTest11826 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a13189 = param; //assign
		StringBuilder b13189 = new StringBuilder(a13189);  // stick in stringbuilder
		b13189.append(" SafeStuff"); // append some safe content
		b13189.replace(b13189.length()-"Chars".length(),b13189.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13189 = new java.util.HashMap<String,Object>();
		map13189.put("key13189", b13189.toString()); // put in a collection
		String c13189 = (String)map13189.get("key13189"); // get it back out
		String d13189 = c13189.substring(0,c13189.length()-1); // extract most of it
		String e13189 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13189.getBytes() ) )); // B64 encode and decode it
		String f13189 = e13189.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13189 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13189); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
