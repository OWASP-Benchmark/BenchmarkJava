package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09816")
public class BenchmarkTest09816 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30968 = param; //assign
		StringBuilder b30968 = new StringBuilder(a30968);  // stick in stringbuilder
		b30968.append(" SafeStuff"); // append some safe content
		b30968.replace(b30968.length()-"Chars".length(),b30968.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30968 = new java.util.HashMap<String,Object>();
		map30968.put("key30968", b30968.toString()); // put in a collection
		String c30968 = (String)map30968.get("key30968"); // get it back out
		String d30968 = c30968.substring(0,c30968.length()-1); // extract most of it
		String e30968 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30968.getBytes() ) )); // B64 encode and decode it
		String f30968 = e30968.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30968); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
