package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13666")
public class BenchmarkTest13666 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a25092 = param; //assign
		StringBuilder b25092 = new StringBuilder(a25092);  // stick in stringbuilder
		b25092.append(" SafeStuff"); // append some safe content
		b25092.replace(b25092.length()-"Chars".length(),b25092.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map25092 = new java.util.HashMap<String,Object>();
		map25092.put("key25092", b25092.toString()); // put in a collection
		String c25092 = (String)map25092.get("key25092"); // get it back out
		String d25092 = c25092.substring(0,c25092.length()-1); // extract most of it
		String e25092 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d25092.getBytes() ) )); // B64 encode and decode it
		String f25092 = e25092.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g25092 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g25092); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
