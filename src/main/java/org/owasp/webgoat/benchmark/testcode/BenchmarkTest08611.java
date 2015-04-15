package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08611")
public class BenchmarkTest08611 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34611 = param; //assign
		StringBuilder b34611 = new StringBuilder(a34611);  // stick in stringbuilder
		b34611.append(" SafeStuff"); // append some safe content
		b34611.replace(b34611.length()-"Chars".length(),b34611.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34611 = new java.util.HashMap<String,Object>();
		map34611.put("key34611", b34611.toString()); // put in a collection
		String c34611 = (String)map34611.get("key34611"); // get it back out
		String d34611 = c34611.substring(0,c34611.length()-1); // extract most of it
		String e34611 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34611.getBytes() ) )); // B64 encode and decode it
		String f34611 = e34611.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34611); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
