package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09854")
public class BenchmarkTest09854 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71910 = param; //assign
		StringBuilder b71910 = new StringBuilder(a71910);  // stick in stringbuilder
		b71910.append(" SafeStuff"); // append some safe content
		b71910.replace(b71910.length()-"Chars".length(),b71910.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71910 = new java.util.HashMap<String,Object>();
		map71910.put("key71910", b71910.toString()); // put in a collection
		String c71910 = (String)map71910.get("key71910"); // get it back out
		String d71910 = c71910.substring(0,c71910.length()-1); // extract most of it
		String e71910 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71910.getBytes() ) )); // B64 encode and decode it
		String f71910 = e71910.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71910); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
