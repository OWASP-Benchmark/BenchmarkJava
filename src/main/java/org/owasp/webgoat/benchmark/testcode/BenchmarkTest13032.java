package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13032")
public class BenchmarkTest13032 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55215 = param; //assign
		StringBuilder b55215 = new StringBuilder(a55215);  // stick in stringbuilder
		b55215.append(" SafeStuff"); // append some safe content
		b55215.replace(b55215.length()-"Chars".length(),b55215.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55215 = new java.util.HashMap<String,Object>();
		map55215.put("key55215", b55215.toString()); // put in a collection
		String c55215 = (String)map55215.get("key55215"); // get it back out
		String d55215 = c55215.substring(0,c55215.length()-1); // extract most of it
		String e55215 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55215.getBytes() ) )); // B64 encode and decode it
		String f55215 = e55215.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f55215); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
