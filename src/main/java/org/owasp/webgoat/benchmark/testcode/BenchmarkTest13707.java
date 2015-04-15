package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13707")
public class BenchmarkTest13707 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a10736 = param; //assign
		StringBuilder b10736 = new StringBuilder(a10736);  // stick in stringbuilder
		b10736.append(" SafeStuff"); // append some safe content
		b10736.replace(b10736.length()-"Chars".length(),b10736.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map10736 = new java.util.HashMap<String,Object>();
		map10736.put("key10736", b10736.toString()); // put in a collection
		String c10736 = (String)map10736.get("key10736"); // get it back out
		String d10736 = c10736.substring(0,c10736.length()-1); // extract most of it
		String e10736 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d10736.getBytes() ) )); // B64 encode and decode it
		String f10736 = e10736.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f10736); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
