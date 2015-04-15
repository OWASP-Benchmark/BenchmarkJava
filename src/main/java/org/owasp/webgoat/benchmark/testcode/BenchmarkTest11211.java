package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11211")
public class BenchmarkTest11211 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5649 = param; //assign
		StringBuilder b5649 = new StringBuilder(a5649);  // stick in stringbuilder
		b5649.append(" SafeStuff"); // append some safe content
		b5649.replace(b5649.length()-"Chars".length(),b5649.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5649 = new java.util.HashMap<String,Object>();
		map5649.put("key5649", b5649.toString()); // put in a collection
		String c5649 = (String)map5649.get("key5649"); // get it back out
		String d5649 = c5649.substring(0,c5649.length()-1); // extract most of it
		String e5649 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5649.getBytes() ) )); // B64 encode and decode it
		String f5649 = e5649.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5649); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
