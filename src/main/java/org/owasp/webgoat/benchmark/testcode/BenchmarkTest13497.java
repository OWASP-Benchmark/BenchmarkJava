package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13497")
public class BenchmarkTest13497 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45894 = param; //assign
		StringBuilder b45894 = new StringBuilder(a45894);  // stick in stringbuilder
		b45894.append(" SafeStuff"); // append some safe content
		b45894.replace(b45894.length()-"Chars".length(),b45894.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45894 = new java.util.HashMap<String,Object>();
		map45894.put("key45894", b45894.toString()); // put in a collection
		String c45894 = (String)map45894.get("key45894"); // get it back out
		String d45894 = c45894.substring(0,c45894.length()-1); // extract most of it
		String e45894 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45894.getBytes() ) )); // B64 encode and decode it
		String f45894 = e45894.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f45894); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
