package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13593")
public class BenchmarkTest13593 extends HttpServlet {
	
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
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a59200 = param; //assign
		StringBuilder b59200 = new StringBuilder(a59200);  // stick in stringbuilder
		b59200.append(" SafeStuff"); // append some safe content
		b59200.replace(b59200.length()-"Chars".length(),b59200.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59200 = new java.util.HashMap<String,Object>();
		map59200.put("key59200", b59200.toString()); // put in a collection
		String c59200 = (String)map59200.get("key59200"); // get it back out
		String d59200 = c59200.substring(0,c59200.length()-1); // extract most of it
		String e59200 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59200.getBytes() ) )); // B64 encode and decode it
		String f59200 = e59200.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f59200); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
