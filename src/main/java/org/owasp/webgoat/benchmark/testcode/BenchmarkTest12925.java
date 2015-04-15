package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12925")
public class BenchmarkTest12925 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a18884 = param; //assign
		StringBuilder b18884 = new StringBuilder(a18884);  // stick in stringbuilder
		b18884.append(" SafeStuff"); // append some safe content
		b18884.replace(b18884.length()-"Chars".length(),b18884.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18884 = new java.util.HashMap<String,Object>();
		map18884.put("key18884", b18884.toString()); // put in a collection
		String c18884 = (String)map18884.get("key18884"); // get it back out
		String d18884 = c18884.substring(0,c18884.length()-1); // extract most of it
		String e18884 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18884.getBytes() ) )); // B64 encode and decode it
		String f18884 = e18884.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f18884); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
