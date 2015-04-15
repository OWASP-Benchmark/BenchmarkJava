package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08592")
public class BenchmarkTest08592 extends HttpServlet {
	
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
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43186 = param; //assign
		StringBuilder b43186 = new StringBuilder(a43186);  // stick in stringbuilder
		b43186.append(" SafeStuff"); // append some safe content
		b43186.replace(b43186.length()-"Chars".length(),b43186.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43186 = new java.util.HashMap<String,Object>();
		map43186.put("key43186", b43186.toString()); // put in a collection
		String c43186 = (String)map43186.get("key43186"); // get it back out
		String d43186 = c43186.substring(0,c43186.length()-1); // extract most of it
		String e43186 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43186.getBytes() ) )); // B64 encode and decode it
		String f43186 = e43186.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43186 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43186); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
