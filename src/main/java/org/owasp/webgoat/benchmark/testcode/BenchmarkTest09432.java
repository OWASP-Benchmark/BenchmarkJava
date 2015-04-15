package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09432")
public class BenchmarkTest09432 extends HttpServlet {
	
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
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67636 = param; //assign
		StringBuilder b67636 = new StringBuilder(a67636);  // stick in stringbuilder
		b67636.append(" SafeStuff"); // append some safe content
		b67636.replace(b67636.length()-"Chars".length(),b67636.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67636 = new java.util.HashMap<String,Object>();
		map67636.put("key67636", b67636.toString()); // put in a collection
		String c67636 = (String)map67636.get("key67636"); // get it back out
		String d67636 = c67636.substring(0,c67636.length()-1); // extract most of it
		String e67636 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67636.getBytes() ) )); // B64 encode and decode it
		String f67636 = e67636.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f67636); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
