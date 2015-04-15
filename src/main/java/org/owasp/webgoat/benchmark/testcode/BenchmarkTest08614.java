package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08614")
public class BenchmarkTest08614 extends HttpServlet {
	
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
		String a40247 = param; //assign
		StringBuilder b40247 = new StringBuilder(a40247);  // stick in stringbuilder
		b40247.append(" SafeStuff"); // append some safe content
		b40247.replace(b40247.length()-"Chars".length(),b40247.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40247 = new java.util.HashMap<String,Object>();
		map40247.put("key40247", b40247.toString()); // put in a collection
		String c40247 = (String)map40247.get("key40247"); // get it back out
		String d40247 = c40247.substring(0,c40247.length()-1); // extract most of it
		String e40247 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40247.getBytes() ) )); // B64 encode and decode it
		String f40247 = e40247.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g40247 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g40247); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
