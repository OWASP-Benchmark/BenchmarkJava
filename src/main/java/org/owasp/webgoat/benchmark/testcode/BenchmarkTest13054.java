package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13054")
public class BenchmarkTest13054 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34334 = param; //assign
		StringBuilder b34334 = new StringBuilder(a34334);  // stick in stringbuilder
		b34334.append(" SafeStuff"); // append some safe content
		b34334.replace(b34334.length()-"Chars".length(),b34334.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34334 = new java.util.HashMap<String,Object>();
		map34334.put("key34334", b34334.toString()); // put in a collection
		String c34334 = (String)map34334.get("key34334"); // get it back out
		String d34334 = c34334.substring(0,c34334.length()-1); // extract most of it
		String e34334 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34334.getBytes() ) )); // B64 encode and decode it
		String f34334 = e34334.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34334); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
