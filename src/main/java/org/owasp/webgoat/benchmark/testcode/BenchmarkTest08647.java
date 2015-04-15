package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08647")
public class BenchmarkTest08647 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a82069 = param; //assign
		StringBuilder b82069 = new StringBuilder(a82069);  // stick in stringbuilder
		b82069.append(" SafeStuff"); // append some safe content
		b82069.replace(b82069.length()-"Chars".length(),b82069.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82069 = new java.util.HashMap<String,Object>();
		map82069.put("key82069", b82069.toString()); // put in a collection
		String c82069 = (String)map82069.get("key82069"); // get it back out
		String d82069 = c82069.substring(0,c82069.length()-1); // extract most of it
		String e82069 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82069.getBytes() ) )); // B64 encode and decode it
		String f82069 = e82069.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82069); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
