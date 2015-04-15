package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09785")
public class BenchmarkTest09785 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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
		String a35078 = param; //assign
		StringBuilder b35078 = new StringBuilder(a35078);  // stick in stringbuilder
		b35078.append(" SafeStuff"); // append some safe content
		b35078.replace(b35078.length()-"Chars".length(),b35078.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35078 = new java.util.HashMap<String,Object>();
		map35078.put("key35078", b35078.toString()); // put in a collection
		String c35078 = (String)map35078.get("key35078"); // get it back out
		String d35078 = c35078.substring(0,c35078.length()-1); // extract most of it
		String e35078 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35078.getBytes() ) )); // B64 encode and decode it
		String f35078 = e35078.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35078 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35078); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
