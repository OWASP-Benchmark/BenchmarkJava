package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09326")
public class BenchmarkTest09326 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7402 = param; //assign
		StringBuilder b7402 = new StringBuilder(a7402);  // stick in stringbuilder
		b7402.append(" SafeStuff"); // append some safe content
		b7402.replace(b7402.length()-"Chars".length(),b7402.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7402 = new java.util.HashMap<String,Object>();
		map7402.put("key7402", b7402.toString()); // put in a collection
		String c7402 = (String)map7402.get("key7402"); // get it back out
		String d7402 = c7402.substring(0,c7402.length()-1); // extract most of it
		String e7402 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7402.getBytes() ) )); // B64 encode and decode it
		String f7402 = e7402.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f7402); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
