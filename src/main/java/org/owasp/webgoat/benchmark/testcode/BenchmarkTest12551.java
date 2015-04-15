package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12551")
public class BenchmarkTest12551 extends HttpServlet {
	
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
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86307 = param; //assign
		StringBuilder b86307 = new StringBuilder(a86307);  // stick in stringbuilder
		b86307.append(" SafeStuff"); // append some safe content
		b86307.replace(b86307.length()-"Chars".length(),b86307.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86307 = new java.util.HashMap<String,Object>();
		map86307.put("key86307", b86307.toString()); // put in a collection
		String c86307 = (String)map86307.get("key86307"); // get it back out
		String d86307 = c86307.substring(0,c86307.length()-1); // extract most of it
		String e86307 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86307.getBytes() ) )); // B64 encode and decode it
		String f86307 = e86307.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86307 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86307); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
