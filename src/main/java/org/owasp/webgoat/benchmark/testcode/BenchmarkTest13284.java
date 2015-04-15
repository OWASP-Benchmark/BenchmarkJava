package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13284")
public class BenchmarkTest13284 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36396 = param; //assign
		StringBuilder b36396 = new StringBuilder(a36396);  // stick in stringbuilder
		b36396.append(" SafeStuff"); // append some safe content
		b36396.replace(b36396.length()-"Chars".length(),b36396.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36396 = new java.util.HashMap<String,Object>();
		map36396.put("key36396", b36396.toString()); // put in a collection
		String c36396 = (String)map36396.get("key36396"); // get it back out
		String d36396 = c36396.substring(0,c36396.length()-1); // extract most of it
		String e36396 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36396.getBytes() ) )); // B64 encode and decode it
		String f36396 = e36396.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f36396); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
