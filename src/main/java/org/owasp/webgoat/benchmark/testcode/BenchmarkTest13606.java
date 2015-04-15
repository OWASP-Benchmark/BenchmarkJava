package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13606")
public class BenchmarkTest13606 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14303 = param; //assign
		StringBuilder b14303 = new StringBuilder(a14303);  // stick in stringbuilder
		b14303.append(" SafeStuff"); // append some safe content
		b14303.replace(b14303.length()-"Chars".length(),b14303.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14303 = new java.util.HashMap<String,Object>();
		map14303.put("key14303", b14303.toString()); // put in a collection
		String c14303 = (String)map14303.get("key14303"); // get it back out
		String d14303 = c14303.substring(0,c14303.length()-1); // extract most of it
		String e14303 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14303.getBytes() ) )); // B64 encode and decode it
		String f14303 = e14303.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14303); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
