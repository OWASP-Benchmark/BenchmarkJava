package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12282")
public class BenchmarkTest12282 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67398 = param; //assign
		StringBuilder b67398 = new StringBuilder(a67398);  // stick in stringbuilder
		b67398.append(" SafeStuff"); // append some safe content
		b67398.replace(b67398.length()-"Chars".length(),b67398.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67398 = new java.util.HashMap<String,Object>();
		map67398.put("key67398", b67398.toString()); // put in a collection
		String c67398 = (String)map67398.get("key67398"); // get it back out
		String d67398 = c67398.substring(0,c67398.length()-1); // extract most of it
		String e67398 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67398.getBytes() ) )); // B64 encode and decode it
		String f67398 = e67398.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f67398); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
