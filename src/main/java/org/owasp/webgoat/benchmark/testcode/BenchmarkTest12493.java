package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12493")
public class BenchmarkTest12493 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93017 = param; //assign
		StringBuilder b93017 = new StringBuilder(a93017);  // stick in stringbuilder
		b93017.append(" SafeStuff"); // append some safe content
		b93017.replace(b93017.length()-"Chars".length(),b93017.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93017 = new java.util.HashMap<String,Object>();
		map93017.put("key93017", b93017.toString()); // put in a collection
		String c93017 = (String)map93017.get("key93017"); // get it back out
		String d93017 = c93017.substring(0,c93017.length()-1); // extract most of it
		String e93017 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93017.getBytes() ) )); // B64 encode and decode it
		String f93017 = e93017.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93017); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
