package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13923")
public class BenchmarkTest13923 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a65322 = param; //assign
		StringBuilder b65322 = new StringBuilder(a65322);  // stick in stringbuilder
		b65322.append(" SafeStuff"); // append some safe content
		b65322.replace(b65322.length()-"Chars".length(),b65322.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65322 = new java.util.HashMap<String,Object>();
		map65322.put("key65322", b65322.toString()); // put in a collection
		String c65322 = (String)map65322.get("key65322"); // get it back out
		String d65322 = c65322.substring(0,c65322.length()-1); // extract most of it
		String e65322 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65322.getBytes() ) )); // B64 encode and decode it
		String f65322 = e65322.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f65322); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
