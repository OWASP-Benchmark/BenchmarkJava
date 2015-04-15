package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12376")
public class BenchmarkTest12376 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70555 = param; //assign
		StringBuilder b70555 = new StringBuilder(a70555);  // stick in stringbuilder
		b70555.append(" SafeStuff"); // append some safe content
		b70555.replace(b70555.length()-"Chars".length(),b70555.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70555 = new java.util.HashMap<String,Object>();
		map70555.put("key70555", b70555.toString()); // put in a collection
		String c70555 = (String)map70555.get("key70555"); // get it back out
		String d70555 = c70555.substring(0,c70555.length()-1); // extract most of it
		String e70555 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70555.getBytes() ) )); // B64 encode and decode it
		String f70555 = e70555.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70555 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70555); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
