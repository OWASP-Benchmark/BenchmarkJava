package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12440")
public class BenchmarkTest12440 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19756 = param; //assign
		StringBuilder b19756 = new StringBuilder(a19756);  // stick in stringbuilder
		b19756.append(" SafeStuff"); // append some safe content
		b19756.replace(b19756.length()-"Chars".length(),b19756.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19756 = new java.util.HashMap<String,Object>();
		map19756.put("key19756", b19756.toString()); // put in a collection
		String c19756 = (String)map19756.get("key19756"); // get it back out
		String d19756 = c19756.substring(0,c19756.length()-1); // extract most of it
		String e19756 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19756.getBytes() ) )); // B64 encode and decode it
		String f19756 = e19756.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19756 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19756); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
