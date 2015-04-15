package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12285")
public class BenchmarkTest12285 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75035 = param; //assign
		StringBuilder b75035 = new StringBuilder(a75035);  // stick in stringbuilder
		b75035.append(" SafeStuff"); // append some safe content
		b75035.replace(b75035.length()-"Chars".length(),b75035.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75035 = new java.util.HashMap<String,Object>();
		map75035.put("key75035", b75035.toString()); // put in a collection
		String c75035 = (String)map75035.get("key75035"); // get it back out
		String d75035 = c75035.substring(0,c75035.length()-1); // extract most of it
		String e75035 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75035.getBytes() ) )); // B64 encode and decode it
		String f75035 = e75035.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g75035 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75035); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
