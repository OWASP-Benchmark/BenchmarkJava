package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09220")
public class BenchmarkTest09220 extends HttpServlet {
	
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
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a85843 = param; //assign
		StringBuilder b85843 = new StringBuilder(a85843);  // stick in stringbuilder
		b85843.append(" SafeStuff"); // append some safe content
		b85843.replace(b85843.length()-"Chars".length(),b85843.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85843 = new java.util.HashMap<String,Object>();
		map85843.put("key85843", b85843.toString()); // put in a collection
		String c85843 = (String)map85843.get("key85843"); // get it back out
		String d85843 = c85843.substring(0,c85843.length()-1); // extract most of it
		String e85843 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85843.getBytes() ) )); // B64 encode and decode it
		String f85843 = e85843.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g85843 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g85843); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
