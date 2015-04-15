package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12315")
public class BenchmarkTest12315 extends HttpServlet {
	
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
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35908 = param; //assign
		StringBuilder b35908 = new StringBuilder(a35908);  // stick in stringbuilder
		b35908.append(" SafeStuff"); // append some safe content
		b35908.replace(b35908.length()-"Chars".length(),b35908.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35908 = new java.util.HashMap<String,Object>();
		map35908.put("key35908", b35908.toString()); // put in a collection
		String c35908 = (String)map35908.get("key35908"); // get it back out
		String d35908 = c35908.substring(0,c35908.length()-1); // extract most of it
		String e35908 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35908.getBytes() ) )); // B64 encode and decode it
		String f35908 = e35908.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35908 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35908); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
