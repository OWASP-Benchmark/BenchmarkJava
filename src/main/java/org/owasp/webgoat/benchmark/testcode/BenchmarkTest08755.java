package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08755")
public class BenchmarkTest08755 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45448 = param; //assign
		StringBuilder b45448 = new StringBuilder(a45448);  // stick in stringbuilder
		b45448.append(" SafeStuff"); // append some safe content
		b45448.replace(b45448.length()-"Chars".length(),b45448.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45448 = new java.util.HashMap<String,Object>();
		map45448.put("key45448", b45448.toString()); // put in a collection
		String c45448 = (String)map45448.get("key45448"); // get it back out
		String d45448 = c45448.substring(0,c45448.length()-1); // extract most of it
		String e45448 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45448.getBytes() ) )); // B64 encode and decode it
		String f45448 = e45448.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45448); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
