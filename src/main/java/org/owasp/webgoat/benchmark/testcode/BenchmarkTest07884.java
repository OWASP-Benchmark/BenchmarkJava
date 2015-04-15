package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07884")
public class BenchmarkTest07884 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88753 = param; //assign
		StringBuilder b88753 = new StringBuilder(a88753);  // stick in stringbuilder
		b88753.append(" SafeStuff"); // append some safe content
		b88753.replace(b88753.length()-"Chars".length(),b88753.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88753 = new java.util.HashMap<String,Object>();
		map88753.put("key88753", b88753.toString()); // put in a collection
		String c88753 = (String)map88753.get("key88753"); // get it back out
		String d88753 = c88753.substring(0,c88753.length()-1); // extract most of it
		String e88753 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88753.getBytes() ) )); // B64 encode and decode it
		String f88753 = e88753.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88753); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
