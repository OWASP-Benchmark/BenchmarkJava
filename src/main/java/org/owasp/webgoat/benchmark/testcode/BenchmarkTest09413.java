package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09413")
public class BenchmarkTest09413 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a65631 = param; //assign
		StringBuilder b65631 = new StringBuilder(a65631);  // stick in stringbuilder
		b65631.append(" SafeStuff"); // append some safe content
		b65631.replace(b65631.length()-"Chars".length(),b65631.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65631 = new java.util.HashMap<String,Object>();
		map65631.put("key65631", b65631.toString()); // put in a collection
		String c65631 = (String)map65631.get("key65631"); // get it back out
		String d65631 = c65631.substring(0,c65631.length()-1); // extract most of it
		String e65631 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65631.getBytes() ) )); // B64 encode and decode it
		String f65631 = e65631.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f65631); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
