package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08536")
public class BenchmarkTest08536 extends HttpServlet {
	
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
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a42582 = param; //assign
		StringBuilder b42582 = new StringBuilder(a42582);  // stick in stringbuilder
		b42582.append(" SafeStuff"); // append some safe content
		b42582.replace(b42582.length()-"Chars".length(),b42582.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map42582 = new java.util.HashMap<String,Object>();
		map42582.put("key42582", b42582.toString()); // put in a collection
		String c42582 = (String)map42582.get("key42582"); // get it back out
		String d42582 = c42582.substring(0,c42582.length()-1); // extract most of it
		String e42582 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d42582.getBytes() ) )); // B64 encode and decode it
		String f42582 = e42582.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f42582); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
