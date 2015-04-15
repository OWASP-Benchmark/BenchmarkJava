package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13826")
public class BenchmarkTest13826 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36705 = param; //assign
		StringBuilder b36705 = new StringBuilder(a36705);  // stick in stringbuilder
		b36705.append(" SafeStuff"); // append some safe content
		b36705.replace(b36705.length()-"Chars".length(),b36705.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36705 = new java.util.HashMap<String,Object>();
		map36705.put("key36705", b36705.toString()); // put in a collection
		String c36705 = (String)map36705.get("key36705"); // get it back out
		String d36705 = c36705.substring(0,c36705.length()-1); // extract most of it
		String e36705 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36705.getBytes() ) )); // B64 encode and decode it
		String f36705 = e36705.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g36705 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g36705); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
