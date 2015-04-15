package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08605")
public class BenchmarkTest08605 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a42628 = param; //assign
		StringBuilder b42628 = new StringBuilder(a42628);  // stick in stringbuilder
		b42628.append(" SafeStuff"); // append some safe content
		b42628.replace(b42628.length()-"Chars".length(),b42628.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map42628 = new java.util.HashMap<String,Object>();
		map42628.put("key42628", b42628.toString()); // put in a collection
		String c42628 = (String)map42628.get("key42628"); // get it back out
		String d42628 = c42628.substring(0,c42628.length()-1); // extract most of it
		String e42628 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d42628.getBytes() ) )); // B64 encode and decode it
		String f42628 = e42628.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f42628); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
