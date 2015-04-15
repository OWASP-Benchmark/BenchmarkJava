package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12906")
public class BenchmarkTest12906 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		// FILE URIs are tricky because they are different between Mac and Windows because of lack of standardization.
		// Mac requires an extra slash for some reason.
		String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        	startURIslashes = "/";
	        else startURIslashes = "//";

		try {
			java.net.URI fileURI = new java.net.URI("file:" + startURIslashes 
				+ org.owasp.webgoat.benchmark.helpers.Utils.testfileDir.replace('\\', '/').replace(' ', '_') + bar);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34983 = param; //assign
		StringBuilder b34983 = new StringBuilder(a34983);  // stick in stringbuilder
		b34983.append(" SafeStuff"); // append some safe content
		b34983.replace(b34983.length()-"Chars".length(),b34983.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34983 = new java.util.HashMap<String,Object>();
		map34983.put("key34983", b34983.toString()); // put in a collection
		String c34983 = (String)map34983.get("key34983"); // get it back out
		String d34983 = c34983.substring(0,c34983.length()-1); // extract most of it
		String e34983 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34983.getBytes() ) )); // B64 encode and decode it
		String f34983 = e34983.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f34983); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
