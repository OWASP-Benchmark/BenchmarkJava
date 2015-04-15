package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12352")
public class BenchmarkTest12352 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72037 = param; //assign
		StringBuilder b72037 = new StringBuilder(a72037);  // stick in stringbuilder
		b72037.append(" SafeStuff"); // append some safe content
		b72037.replace(b72037.length()-"Chars".length(),b72037.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72037 = new java.util.HashMap<String,Object>();
		map72037.put("key72037", b72037.toString()); // put in a collection
		String c72037 = (String)map72037.get("key72037"); // get it back out
		String d72037 = c72037.substring(0,c72037.length()-1); // extract most of it
		String e72037 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72037.getBytes() ) )); // B64 encode and decode it
		String f72037 = e72037.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g72037 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72037); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
