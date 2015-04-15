package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11623")
public class BenchmarkTest11623 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21383 = param; //assign
		StringBuilder b21383 = new StringBuilder(a21383);  // stick in stringbuilder
		b21383.append(" SafeStuff"); // append some safe content
		b21383.replace(b21383.length()-"Chars".length(),b21383.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21383 = new java.util.HashMap<String,Object>();
		map21383.put("key21383", b21383.toString()); // put in a collection
		String c21383 = (String)map21383.get("key21383"); // get it back out
		String d21383 = c21383.substring(0,c21383.length()-1); // extract most of it
		String e21383 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21383.getBytes() ) )); // B64 encode and decode it
		String f21383 = e21383.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21383); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
