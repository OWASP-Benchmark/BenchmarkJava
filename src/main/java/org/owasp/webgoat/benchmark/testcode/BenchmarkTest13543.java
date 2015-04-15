package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13543")
public class BenchmarkTest13543 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a69296 = param; //assign
		StringBuilder b69296 = new StringBuilder(a69296);  // stick in stringbuilder
		b69296.append(" SafeStuff"); // append some safe content
		b69296.replace(b69296.length()-"Chars".length(),b69296.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69296 = new java.util.HashMap<String,Object>();
		map69296.put("key69296", b69296.toString()); // put in a collection
		String c69296 = (String)map69296.get("key69296"); // get it back out
		String d69296 = c69296.substring(0,c69296.length()-1); // extract most of it
		String e69296 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69296.getBytes() ) )); // B64 encode and decode it
		String f69296 = e69296.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f69296); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
