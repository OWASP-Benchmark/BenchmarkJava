package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12412")
public class BenchmarkTest12412 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50683 = param; //assign
		StringBuilder b50683 = new StringBuilder(a50683);  // stick in stringbuilder
		b50683.append(" SafeStuff"); // append some safe content
		b50683.replace(b50683.length()-"Chars".length(),b50683.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50683 = new java.util.HashMap<String,Object>();
		map50683.put("key50683", b50683.toString()); // put in a collection
		String c50683 = (String)map50683.get("key50683"); // get it back out
		String d50683 = c50683.substring(0,c50683.length()-1); // extract most of it
		String e50683 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50683.getBytes() ) )); // B64 encode and decode it
		String f50683 = e50683.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f50683); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
