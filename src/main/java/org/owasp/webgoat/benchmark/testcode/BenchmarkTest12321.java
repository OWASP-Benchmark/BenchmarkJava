package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12321")
public class BenchmarkTest12321 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86896 = param; //assign
		StringBuilder b86896 = new StringBuilder(a86896);  // stick in stringbuilder
		b86896.append(" SafeStuff"); // append some safe content
		b86896.replace(b86896.length()-"Chars".length(),b86896.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86896 = new java.util.HashMap<String,Object>();
		map86896.put("key86896", b86896.toString()); // put in a collection
		String c86896 = (String)map86896.get("key86896"); // get it back out
		String d86896 = c86896.substring(0,c86896.length()-1); // extract most of it
		String e86896 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86896.getBytes() ) )); // B64 encode and decode it
		String f86896 = e86896.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86896); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
