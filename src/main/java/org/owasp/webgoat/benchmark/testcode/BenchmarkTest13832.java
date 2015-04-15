package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13832")
public class BenchmarkTest13832 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15975 = param; //assign
		StringBuilder b15975 = new StringBuilder(a15975);  // stick in stringbuilder
		b15975.append(" SafeStuff"); // append some safe content
		b15975.replace(b15975.length()-"Chars".length(),b15975.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15975 = new java.util.HashMap<String,Object>();
		map15975.put("key15975", b15975.toString()); // put in a collection
		String c15975 = (String)map15975.get("key15975"); // get it back out
		String d15975 = c15975.substring(0,c15975.length()-1); // extract most of it
		String e15975 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15975.getBytes() ) )); // B64 encode and decode it
		String f15975 = e15975.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15975); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
