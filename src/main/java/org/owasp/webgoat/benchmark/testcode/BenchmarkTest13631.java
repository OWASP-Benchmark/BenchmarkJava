package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13631")
public class BenchmarkTest13631 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72313 = param; //assign
		StringBuilder b72313 = new StringBuilder(a72313);  // stick in stringbuilder
		b72313.append(" SafeStuff"); // append some safe content
		b72313.replace(b72313.length()-"Chars".length(),b72313.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72313 = new java.util.HashMap<String,Object>();
		map72313.put("key72313", b72313.toString()); // put in a collection
		String c72313 = (String)map72313.get("key72313"); // get it back out
		String d72313 = c72313.substring(0,c72313.length()-1); // extract most of it
		String e72313 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72313.getBytes() ) )); // B64 encode and decode it
		String f72313 = e72313.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72313); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
