package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12457")
public class BenchmarkTest12457 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70302 = param; //assign
		StringBuilder b70302 = new StringBuilder(a70302);  // stick in stringbuilder
		b70302.append(" SafeStuff"); // append some safe content
		b70302.replace(b70302.length()-"Chars".length(),b70302.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70302 = new java.util.HashMap<String,Object>();
		map70302.put("key70302", b70302.toString()); // put in a collection
		String c70302 = (String)map70302.get("key70302"); // get it back out
		String d70302 = c70302.substring(0,c70302.length()-1); // extract most of it
		String e70302 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70302.getBytes() ) )); // B64 encode and decode it
		String f70302 = e70302.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70302 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70302); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
