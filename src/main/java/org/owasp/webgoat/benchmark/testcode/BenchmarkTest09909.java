package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09909")
public class BenchmarkTest09909 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94956 = param; //assign
		StringBuilder b94956 = new StringBuilder(a94956);  // stick in stringbuilder
		b94956.append(" SafeStuff"); // append some safe content
		b94956.replace(b94956.length()-"Chars".length(),b94956.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94956 = new java.util.HashMap<String,Object>();
		map94956.put("key94956", b94956.toString()); // put in a collection
		String c94956 = (String)map94956.get("key94956"); // get it back out
		String d94956 = c94956.substring(0,c94956.length()-1); // extract most of it
		String e94956 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94956.getBytes() ) )); // B64 encode and decode it
		String f94956 = e94956.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94956); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
