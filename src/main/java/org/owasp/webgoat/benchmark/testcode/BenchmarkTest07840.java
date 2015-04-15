package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07840")
public class BenchmarkTest07840 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90748 = param; //assign
		StringBuilder b90748 = new StringBuilder(a90748);  // stick in stringbuilder
		b90748.append(" SafeStuff"); // append some safe content
		b90748.replace(b90748.length()-"Chars".length(),b90748.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90748 = new java.util.HashMap<String,Object>();
		map90748.put("key90748", b90748.toString()); // put in a collection
		String c90748 = (String)map90748.get("key90748"); // get it back out
		String d90748 = c90748.substring(0,c90748.length()-1); // extract most of it
		String e90748 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90748.getBytes() ) )); // B64 encode and decode it
		String f90748 = e90748.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90748); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
