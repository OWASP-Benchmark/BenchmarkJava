package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09898")
public class BenchmarkTest09898 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45519 = param; //assign
		StringBuilder b45519 = new StringBuilder(a45519);  // stick in stringbuilder
		b45519.append(" SafeStuff"); // append some safe content
		b45519.replace(b45519.length()-"Chars".length(),b45519.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45519 = new java.util.HashMap<String,Object>();
		map45519.put("key45519", b45519.toString()); // put in a collection
		String c45519 = (String)map45519.get("key45519"); // get it back out
		String d45519 = c45519.substring(0,c45519.length()-1); // extract most of it
		String e45519 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45519.getBytes() ) )); // B64 encode and decode it
		String f45519 = e45519.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45519 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45519); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
