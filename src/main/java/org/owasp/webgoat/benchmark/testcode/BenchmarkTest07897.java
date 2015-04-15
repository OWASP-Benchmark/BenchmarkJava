package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07897")
public class BenchmarkTest07897 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7461 = param; //assign
		StringBuilder b7461 = new StringBuilder(a7461);  // stick in stringbuilder
		b7461.append(" SafeStuff"); // append some safe content
		b7461.replace(b7461.length()-"Chars".length(),b7461.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7461 = new java.util.HashMap<String,Object>();
		map7461.put("key7461", b7461.toString()); // put in a collection
		String c7461 = (String)map7461.get("key7461"); // get it back out
		String d7461 = c7461.substring(0,c7461.length()-1); // extract most of it
		String e7461 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7461.getBytes() ) )); // B64 encode and decode it
		String f7461 = e7461.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f7461); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
