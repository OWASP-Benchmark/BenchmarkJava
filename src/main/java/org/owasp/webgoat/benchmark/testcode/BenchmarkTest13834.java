package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13834")
public class BenchmarkTest13834 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51850 = param; //assign
		StringBuilder b51850 = new StringBuilder(a51850);  // stick in stringbuilder
		b51850.append(" SafeStuff"); // append some safe content
		b51850.replace(b51850.length()-"Chars".length(),b51850.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51850 = new java.util.HashMap<String,Object>();
		map51850.put("key51850", b51850.toString()); // put in a collection
		String c51850 = (String)map51850.get("key51850"); // get it back out
		String d51850 = c51850.substring(0,c51850.length()-1); // extract most of it
		String e51850 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51850.getBytes() ) )); // B64 encode and decode it
		String f51850 = e51850.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51850 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51850); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
