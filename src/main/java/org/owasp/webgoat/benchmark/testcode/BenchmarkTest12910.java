package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12910")
public class BenchmarkTest12910 extends HttpServlet {
	
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
			java.net.URI fileURI = new java.net.URI("file", null, startURIslashes 
				+ org.owasp.webgoat.benchmark.helpers.Utils.testfileDir.replace('\\', java.io.File.separatorChar).replace(' ', '_') + bar, null, null);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a17025 = param; //assign
		StringBuilder b17025 = new StringBuilder(a17025);  // stick in stringbuilder
		b17025.append(" SafeStuff"); // append some safe content
		b17025.replace(b17025.length()-"Chars".length(),b17025.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17025 = new java.util.HashMap<String,Object>();
		map17025.put("key17025", b17025.toString()); // put in a collection
		String c17025 = (String)map17025.get("key17025"); // get it back out
		String d17025 = c17025.substring(0,c17025.length()-1); // extract most of it
		String e17025 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17025.getBytes() ) )); // B64 encode and decode it
		String f17025 = e17025.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f17025); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
