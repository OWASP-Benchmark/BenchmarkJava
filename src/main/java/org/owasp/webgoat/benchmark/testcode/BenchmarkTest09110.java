package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09110")
public class BenchmarkTest09110 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1564 = param; //assign
		StringBuilder b1564 = new StringBuilder(a1564);  // stick in stringbuilder
		b1564.append(" SafeStuff"); // append some safe content
		b1564.replace(b1564.length()-"Chars".length(),b1564.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1564 = new java.util.HashMap<String,Object>();
		map1564.put("key1564", b1564.toString()); // put in a collection
		String c1564 = (String)map1564.get("key1564"); // get it back out
		String d1564 = c1564.substring(0,c1564.length()-1); // extract most of it
		String e1564 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1564.getBytes() ) )); // B64 encode and decode it
		String f1564 = e1564.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g1564 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g1564); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
