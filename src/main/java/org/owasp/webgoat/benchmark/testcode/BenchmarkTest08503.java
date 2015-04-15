package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08503")
public class BenchmarkTest08503 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a22637 = param; //assign
		StringBuilder b22637 = new StringBuilder(a22637);  // stick in stringbuilder
		b22637.append(" SafeStuff"); // append some safe content
		b22637.replace(b22637.length()-"Chars".length(),b22637.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22637 = new java.util.HashMap<String,Object>();
		map22637.put("key22637", b22637.toString()); // put in a collection
		String c22637 = (String)map22637.get("key22637"); // get it back out
		String d22637 = c22637.substring(0,c22637.length()-1); // extract most of it
		String e22637 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22637.getBytes() ) )); // B64 encode and decode it
		String f22637 = e22637.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f22637); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
