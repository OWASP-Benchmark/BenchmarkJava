package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12422")
public class BenchmarkTest12422 extends HttpServlet {
	
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
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30639 = param; //assign
		StringBuilder b30639 = new StringBuilder(a30639);  // stick in stringbuilder
		b30639.append(" SafeStuff"); // append some safe content
		b30639.replace(b30639.length()-"Chars".length(),b30639.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30639 = new java.util.HashMap<String,Object>();
		map30639.put("key30639", b30639.toString()); // put in a collection
		String c30639 = (String)map30639.get("key30639"); // get it back out
		String d30639 = c30639.substring(0,c30639.length()-1); // extract most of it
		String e30639 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30639.getBytes() ) )); // B64 encode and decode it
		String f30639 = e30639.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30639); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
