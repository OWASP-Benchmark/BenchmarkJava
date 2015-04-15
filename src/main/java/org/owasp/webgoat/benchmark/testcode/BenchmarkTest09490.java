package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09490")
public class BenchmarkTest09490 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40378 = param; //assign
		StringBuilder b40378 = new StringBuilder(a40378);  // stick in stringbuilder
		b40378.append(" SafeStuff"); // append some safe content
		b40378.replace(b40378.length()-"Chars".length(),b40378.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40378 = new java.util.HashMap<String,Object>();
		map40378.put("key40378", b40378.toString()); // put in a collection
		String c40378 = (String)map40378.get("key40378"); // get it back out
		String d40378 = c40378.substring(0,c40378.length()-1); // extract most of it
		String e40378 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40378.getBytes() ) )); // B64 encode and decode it
		String f40378 = e40378.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40378); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
