package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10180")
public class BenchmarkTest10180 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47512 = param; //assign
		StringBuilder b47512 = new StringBuilder(a47512);  // stick in stringbuilder
		b47512.append(" SafeStuff"); // append some safe content
		b47512.replace(b47512.length()-"Chars".length(),b47512.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47512 = new java.util.HashMap<String,Object>();
		map47512.put("key47512", b47512.toString()); // put in a collection
		String c47512 = (String)map47512.get("key47512"); // get it back out
		String d47512 = c47512.substring(0,c47512.length()-1); // extract most of it
		String e47512 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47512.getBytes() ) )); // B64 encode and decode it
		String f47512 = e47512.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47512); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
