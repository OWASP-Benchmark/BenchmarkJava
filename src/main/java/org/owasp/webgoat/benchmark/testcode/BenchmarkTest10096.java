package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10096")
public class BenchmarkTest10096 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95101 = param; //assign
		StringBuilder b95101 = new StringBuilder(a95101);  // stick in stringbuilder
		b95101.append(" SafeStuff"); // append some safe content
		b95101.replace(b95101.length()-"Chars".length(),b95101.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95101 = new java.util.HashMap<String,Object>();
		map95101.put("key95101", b95101.toString()); // put in a collection
		String c95101 = (String)map95101.get("key95101"); // get it back out
		String d95101 = c95101.substring(0,c95101.length()-1); // extract most of it
		String e95101 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95101.getBytes() ) )); // B64 encode and decode it
		String f95101 = e95101.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f95101); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
