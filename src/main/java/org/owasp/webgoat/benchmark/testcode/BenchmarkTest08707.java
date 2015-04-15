package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08707")
public class BenchmarkTest08707 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44688 = param; //assign
		StringBuilder b44688 = new StringBuilder(a44688);  // stick in stringbuilder
		b44688.append(" SafeStuff"); // append some safe content
		b44688.replace(b44688.length()-"Chars".length(),b44688.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44688 = new java.util.HashMap<String,Object>();
		map44688.put("key44688", b44688.toString()); // put in a collection
		String c44688 = (String)map44688.get("key44688"); // get it back out
		String d44688 = c44688.substring(0,c44688.length()-1); // extract most of it
		String e44688 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44688.getBytes() ) )); // B64 encode and decode it
		String f44688 = e44688.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44688); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
