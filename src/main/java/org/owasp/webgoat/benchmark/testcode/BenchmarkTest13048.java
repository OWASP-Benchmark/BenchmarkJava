package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13048")
public class BenchmarkTest13048 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32605 = param; //assign
		StringBuilder b32605 = new StringBuilder(a32605);  // stick in stringbuilder
		b32605.append(" SafeStuff"); // append some safe content
		b32605.replace(b32605.length()-"Chars".length(),b32605.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32605 = new java.util.HashMap<String,Object>();
		map32605.put("key32605", b32605.toString()); // put in a collection
		String c32605 = (String)map32605.get("key32605"); // get it back out
		String d32605 = c32605.substring(0,c32605.length()-1); // extract most of it
		String e32605 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32605.getBytes() ) )); // B64 encode and decode it
		String f32605 = e32605.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32605); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
