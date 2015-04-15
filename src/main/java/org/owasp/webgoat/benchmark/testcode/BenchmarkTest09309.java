package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09309")
public class BenchmarkTest09309 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a63570 = param; //assign
		StringBuilder b63570 = new StringBuilder(a63570);  // stick in stringbuilder
		b63570.append(" SafeStuff"); // append some safe content
		b63570.replace(b63570.length()-"Chars".length(),b63570.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63570 = new java.util.HashMap<String,Object>();
		map63570.put("key63570", b63570.toString()); // put in a collection
		String c63570 = (String)map63570.get("key63570"); // get it back out
		String d63570 = c63570.substring(0,c63570.length()-1); // extract most of it
		String e63570 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63570.getBytes() ) )); // B64 encode and decode it
		String f63570 = e63570.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63570); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
