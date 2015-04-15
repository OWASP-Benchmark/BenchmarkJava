package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07977")
public class BenchmarkTest07977 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79267 = param; //assign
		StringBuilder b79267 = new StringBuilder(a79267);  // stick in stringbuilder
		b79267.append(" SafeStuff"); // append some safe content
		b79267.replace(b79267.length()-"Chars".length(),b79267.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79267 = new java.util.HashMap<String,Object>();
		map79267.put("key79267", b79267.toString()); // put in a collection
		String c79267 = (String)map79267.get("key79267"); // get it back out
		String d79267 = c79267.substring(0,c79267.length()-1); // extract most of it
		String e79267 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79267.getBytes() ) )); // B64 encode and decode it
		String f79267 = e79267.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79267); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
