package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12429")
public class BenchmarkTest12429 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1227 = param; //assign
		StringBuilder b1227 = new StringBuilder(a1227);  // stick in stringbuilder
		b1227.append(" SafeStuff"); // append some safe content
		b1227.replace(b1227.length()-"Chars".length(),b1227.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1227 = new java.util.HashMap<String,Object>();
		map1227.put("key1227", b1227.toString()); // put in a collection
		String c1227 = (String)map1227.get("key1227"); // get it back out
		String d1227 = c1227.substring(0,c1227.length()-1); // extract most of it
		String e1227 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1227.getBytes() ) )); // B64 encode and decode it
		String f1227 = e1227.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1227); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
