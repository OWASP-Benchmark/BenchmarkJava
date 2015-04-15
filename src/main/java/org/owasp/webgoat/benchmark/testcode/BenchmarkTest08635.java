package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08635")
public class BenchmarkTest08635 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19160 = param; //assign
		StringBuilder b19160 = new StringBuilder(a19160);  // stick in stringbuilder
		b19160.append(" SafeStuff"); // append some safe content
		b19160.replace(b19160.length()-"Chars".length(),b19160.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19160 = new java.util.HashMap<String,Object>();
		map19160.put("key19160", b19160.toString()); // put in a collection
		String c19160 = (String)map19160.get("key19160"); // get it back out
		String d19160 = c19160.substring(0,c19160.length()-1); // extract most of it
		String e19160 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19160.getBytes() ) )); // B64 encode and decode it
		String f19160 = e19160.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f19160); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
