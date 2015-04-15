package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12618")
public class BenchmarkTest12618 extends HttpServlet {
	
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
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a421 = param; //assign
		StringBuilder b421 = new StringBuilder(a421);  // stick in stringbuilder
		b421.append(" SafeStuff"); // append some safe content
		b421.replace(b421.length()-"Chars".length(),b421.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map421 = new java.util.HashMap<String,Object>();
		map421.put("key421", b421.toString()); // put in a collection
		String c421 = (String)map421.get("key421"); // get it back out
		String d421 = c421.substring(0,c421.length()-1); // extract most of it
		String e421 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d421.getBytes() ) )); // B64 encode and decode it
		String f421 = e421.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f421); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
