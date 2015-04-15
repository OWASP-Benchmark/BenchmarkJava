package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08828")
public class BenchmarkTest08828 extends HttpServlet {
	
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
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50348 = param; //assign
		StringBuilder b50348 = new StringBuilder(a50348);  // stick in stringbuilder
		b50348.append(" SafeStuff"); // append some safe content
		b50348.replace(b50348.length()-"Chars".length(),b50348.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50348 = new java.util.HashMap<String,Object>();
		map50348.put("key50348", b50348.toString()); // put in a collection
		String c50348 = (String)map50348.get("key50348"); // get it back out
		String d50348 = c50348.substring(0,c50348.length()-1); // extract most of it
		String e50348 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50348.getBytes() ) )); // B64 encode and decode it
		String f50348 = e50348.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50348); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
