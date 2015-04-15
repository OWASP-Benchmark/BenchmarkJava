package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12336")
public class BenchmarkTest12336 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67533 = param; //assign
		StringBuilder b67533 = new StringBuilder(a67533);  // stick in stringbuilder
		b67533.append(" SafeStuff"); // append some safe content
		b67533.replace(b67533.length()-"Chars".length(),b67533.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67533 = new java.util.HashMap<String,Object>();
		map67533.put("key67533", b67533.toString()); // put in a collection
		String c67533 = (String)map67533.get("key67533"); // get it back out
		String d67533 = c67533.substring(0,c67533.length()-1); // extract most of it
		String e67533 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67533.getBytes() ) )); // B64 encode and decode it
		String f67533 = e67533.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g67533 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g67533); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
