package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07952")
public class BenchmarkTest07952 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1", "Sun");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a42511 = param; //assign
		StringBuilder b42511 = new StringBuilder(a42511);  // stick in stringbuilder
		b42511.append(" SafeStuff"); // append some safe content
		b42511.replace(b42511.length()-"Chars".length(),b42511.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map42511 = new java.util.HashMap<String,Object>();
		map42511.put("key42511", b42511.toString()); // put in a collection
		String c42511 = (String)map42511.get("key42511"); // get it back out
		String d42511 = c42511.substring(0,c42511.length()-1); // extract most of it
		String e42511 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d42511.getBytes() ) )); // B64 encode and decode it
		String f42511 = e42511.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f42511); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
