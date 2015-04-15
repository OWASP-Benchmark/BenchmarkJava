package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09132")
public class BenchmarkTest09132 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38316 = param; //assign
		StringBuilder b38316 = new StringBuilder(a38316);  // stick in stringbuilder
		b38316.append(" SafeStuff"); // append some safe content
		b38316.replace(b38316.length()-"Chars".length(),b38316.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38316 = new java.util.HashMap<String,Object>();
		map38316.put("key38316", b38316.toString()); // put in a collection
		String c38316 = (String)map38316.get("key38316"); // get it back out
		String d38316 = c38316.substring(0,c38316.length()-1); // extract most of it
		String e38316 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38316.getBytes() ) )); // B64 encode and decode it
		String f38316 = e38316.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38316); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
