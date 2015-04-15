package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12409")
public class BenchmarkTest12409 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37931 = param; //assign
		StringBuilder b37931 = new StringBuilder(a37931);  // stick in stringbuilder
		b37931.append(" SafeStuff"); // append some safe content
		b37931.replace(b37931.length()-"Chars".length(),b37931.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37931 = new java.util.HashMap<String,Object>();
		map37931.put("key37931", b37931.toString()); // put in a collection
		String c37931 = (String)map37931.get("key37931"); // get it back out
		String d37931 = c37931.substring(0,c37931.length()-1); // extract most of it
		String e37931 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37931.getBytes() ) )); // B64 encode and decode it
		String f37931 = e37931.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37931 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37931); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
