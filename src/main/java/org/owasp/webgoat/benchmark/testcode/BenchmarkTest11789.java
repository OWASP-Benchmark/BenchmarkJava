package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11789")
public class BenchmarkTest11789 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91262 = param; //assign
		StringBuilder b91262 = new StringBuilder(a91262);  // stick in stringbuilder
		b91262.append(" SafeStuff"); // append some safe content
		b91262.replace(b91262.length()-"Chars".length(),b91262.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91262 = new java.util.HashMap<String,Object>();
		map91262.put("key91262", b91262.toString()); // put in a collection
		String c91262 = (String)map91262.get("key91262"); // get it back out
		String d91262 = c91262.substring(0,c91262.length()-1); // extract most of it
		String e91262 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91262.getBytes() ) )); // B64 encode and decode it
		String f91262 = e91262.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91262); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
