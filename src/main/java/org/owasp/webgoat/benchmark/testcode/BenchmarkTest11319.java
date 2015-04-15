package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11319")
public class BenchmarkTest11319 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3906 = param; //assign
		StringBuilder b3906 = new StringBuilder(a3906);  // stick in stringbuilder
		b3906.append(" SafeStuff"); // append some safe content
		b3906.replace(b3906.length()-"Chars".length(),b3906.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3906 = new java.util.HashMap<String,Object>();
		map3906.put("key3906", b3906.toString()); // put in a collection
		String c3906 = (String)map3906.get("key3906"); // get it back out
		String d3906 = c3906.substring(0,c3906.length()-1); // extract most of it
		String e3906 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3906.getBytes() ) )); // B64 encode and decode it
		String f3906 = e3906.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3906); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
