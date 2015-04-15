package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09239")
public class BenchmarkTest09239 extends HttpServlet {
	
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
		String a76232 = param; //assign
		StringBuilder b76232 = new StringBuilder(a76232);  // stick in stringbuilder
		b76232.append(" SafeStuff"); // append some safe content
		b76232.replace(b76232.length()-"Chars".length(),b76232.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76232 = new java.util.HashMap<String,Object>();
		map76232.put("key76232", b76232.toString()); // put in a collection
		String c76232 = (String)map76232.get("key76232"); // get it back out
		String d76232 = c76232.substring(0,c76232.length()-1); // extract most of it
		String e76232 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76232.getBytes() ) )); // B64 encode and decode it
		String f76232 = e76232.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f76232); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
