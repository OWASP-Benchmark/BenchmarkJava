package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07889")
public class BenchmarkTest07889 extends HttpServlet {
	
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
		String a75944 = param; //assign
		StringBuilder b75944 = new StringBuilder(a75944);  // stick in stringbuilder
		b75944.append(" SafeStuff"); // append some safe content
		b75944.replace(b75944.length()-"Chars".length(),b75944.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75944 = new java.util.HashMap<String,Object>();
		map75944.put("key75944", b75944.toString()); // put in a collection
		String c75944 = (String)map75944.get("key75944"); // get it back out
		String d75944 = c75944.substring(0,c75944.length()-1); // extract most of it
		String e75944 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75944.getBytes() ) )); // B64 encode and decode it
		String f75944 = e75944.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g75944 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75944); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
