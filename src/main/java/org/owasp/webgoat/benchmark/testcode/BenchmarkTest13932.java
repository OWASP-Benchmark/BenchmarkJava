package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13932")
public class BenchmarkTest13932 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76568 = param; //assign
		StringBuilder b76568 = new StringBuilder(a76568);  // stick in stringbuilder
		b76568.append(" SafeStuff"); // append some safe content
		b76568.replace(b76568.length()-"Chars".length(),b76568.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76568 = new java.util.HashMap<String,Object>();
		map76568.put("key76568", b76568.toString()); // put in a collection
		String c76568 = (String)map76568.get("key76568"); // get it back out
		String d76568 = c76568.substring(0,c76568.length()-1); // extract most of it
		String e76568 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76568.getBytes() ) )); // B64 encode and decode it
		String f76568 = e76568.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76568); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
