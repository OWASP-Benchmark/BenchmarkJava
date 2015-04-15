package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09435")
public class BenchmarkTest09435 extends HttpServlet {
	
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
		String a56880 = param; //assign
		StringBuilder b56880 = new StringBuilder(a56880);  // stick in stringbuilder
		b56880.append(" SafeStuff"); // append some safe content
		b56880.replace(b56880.length()-"Chars".length(),b56880.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56880 = new java.util.HashMap<String,Object>();
		map56880.put("key56880", b56880.toString()); // put in a collection
		String c56880 = (String)map56880.get("key56880"); // get it back out
		String d56880 = c56880.substring(0,c56880.length()-1); // extract most of it
		String e56880 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56880.getBytes() ) )); // B64 encode and decode it
		String f56880 = e56880.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g56880 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g56880); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
