package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08816")
public class BenchmarkTest08816 extends HttpServlet {
	
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
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9240 = param; //assign
		StringBuilder b9240 = new StringBuilder(a9240);  // stick in stringbuilder
		b9240.append(" SafeStuff"); // append some safe content
		b9240.replace(b9240.length()-"Chars".length(),b9240.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9240 = new java.util.HashMap<String,Object>();
		map9240.put("key9240", b9240.toString()); // put in a collection
		String c9240 = (String)map9240.get("key9240"); // get it back out
		String d9240 = c9240.substring(0,c9240.length()-1); // extract most of it
		String e9240 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9240.getBytes() ) )); // B64 encode and decode it
		String f9240 = e9240.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9240); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
