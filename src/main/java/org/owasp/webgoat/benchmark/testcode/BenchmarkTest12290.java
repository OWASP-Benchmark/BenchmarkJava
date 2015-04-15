package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12290")
public class BenchmarkTest12290 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a99653 = param; //assign
		StringBuilder b99653 = new StringBuilder(a99653);  // stick in stringbuilder
		b99653.append(" SafeStuff"); // append some safe content
		b99653.replace(b99653.length()-"Chars".length(),b99653.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99653 = new java.util.HashMap<String,Object>();
		map99653.put("key99653", b99653.toString()); // put in a collection
		String c99653 = (String)map99653.get("key99653"); // get it back out
		String d99653 = c99653.substring(0,c99653.length()-1); // extract most of it
		String e99653 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99653.getBytes() ) )); // B64 encode and decode it
		String f99653 = e99653.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f99653); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
