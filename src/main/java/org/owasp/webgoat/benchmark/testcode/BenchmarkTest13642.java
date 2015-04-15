package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13642")
public class BenchmarkTest13642 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19342 = param; //assign
		StringBuilder b19342 = new StringBuilder(a19342);  // stick in stringbuilder
		b19342.append(" SafeStuff"); // append some safe content
		b19342.replace(b19342.length()-"Chars".length(),b19342.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19342 = new java.util.HashMap<String,Object>();
		map19342.put("key19342", b19342.toString()); // put in a collection
		String c19342 = (String)map19342.get("key19342"); // get it back out
		String d19342 = c19342.substring(0,c19342.length()-1); // extract most of it
		String e19342 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19342.getBytes() ) )); // B64 encode and decode it
		String f19342 = e19342.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19342 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19342); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
