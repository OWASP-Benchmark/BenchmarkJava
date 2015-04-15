package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08077")
public class BenchmarkTest08077 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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
		String a2022 = param; //assign
		StringBuilder b2022 = new StringBuilder(a2022);  // stick in stringbuilder
		b2022.append(" SafeStuff"); // append some safe content
		b2022.replace(b2022.length()-"Chars".length(),b2022.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2022 = new java.util.HashMap<String,Object>();
		map2022.put("key2022", b2022.toString()); // put in a collection
		String c2022 = (String)map2022.get("key2022"); // get it back out
		String d2022 = c2022.substring(0,c2022.length()-1); // extract most of it
		String e2022 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2022.getBytes() ) )); // B64 encode and decode it
		String f2022 = e2022.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f2022); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
