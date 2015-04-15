package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12628")
public class BenchmarkTest12628 extends HttpServlet {
	
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
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a13803 = param; //assign
		StringBuilder b13803 = new StringBuilder(a13803);  // stick in stringbuilder
		b13803.append(" SafeStuff"); // append some safe content
		b13803.replace(b13803.length()-"Chars".length(),b13803.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13803 = new java.util.HashMap<String,Object>();
		map13803.put("key13803", b13803.toString()); // put in a collection
		String c13803 = (String)map13803.get("key13803"); // get it back out
		String d13803 = c13803.substring(0,c13803.length()-1); // extract most of it
		String e13803 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13803.getBytes() ) )); // B64 encode and decode it
		String f13803 = e13803.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13803); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
