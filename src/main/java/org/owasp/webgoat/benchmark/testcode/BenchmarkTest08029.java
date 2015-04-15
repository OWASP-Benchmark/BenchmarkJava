package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08029")
public class BenchmarkTest08029 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a5782 = param; //assign
		StringBuilder b5782 = new StringBuilder(a5782);  // stick in stringbuilder
		b5782.append(" SafeStuff"); // append some safe content
		b5782.replace(b5782.length()-"Chars".length(),b5782.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5782 = new java.util.HashMap<String,Object>();
		map5782.put("key5782", b5782.toString()); // put in a collection
		String c5782 = (String)map5782.get("key5782"); // get it back out
		String d5782 = c5782.substring(0,c5782.length()-1); // extract most of it
		String e5782 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5782.getBytes() ) )); // B64 encode and decode it
		String f5782 = e5782.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g5782 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5782); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
