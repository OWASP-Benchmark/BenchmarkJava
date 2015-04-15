package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13089")
public class BenchmarkTest13089 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6877 = param; //assign
		StringBuilder b6877 = new StringBuilder(a6877);  // stick in stringbuilder
		b6877.append(" SafeStuff"); // append some safe content
		b6877.replace(b6877.length()-"Chars".length(),b6877.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6877 = new java.util.HashMap<String,Object>();
		map6877.put("key6877", b6877.toString()); // put in a collection
		String c6877 = (String)map6877.get("key6877"); // get it back out
		String d6877 = c6877.substring(0,c6877.length()-1); // extract most of it
		String e6877 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6877.getBytes() ) )); // B64 encode and decode it
		String f6877 = e6877.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f6877); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
