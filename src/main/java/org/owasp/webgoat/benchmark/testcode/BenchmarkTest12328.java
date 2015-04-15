package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12328")
public class BenchmarkTest12328 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a54928 = param; //assign
		StringBuilder b54928 = new StringBuilder(a54928);  // stick in stringbuilder
		b54928.append(" SafeStuff"); // append some safe content
		b54928.replace(b54928.length()-"Chars".length(),b54928.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54928 = new java.util.HashMap<String,Object>();
		map54928.put("key54928", b54928.toString()); // put in a collection
		String c54928 = (String)map54928.get("key54928"); // get it back out
		String d54928 = c54928.substring(0,c54928.length()-1); // extract most of it
		String e54928 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54928.getBytes() ) )); // B64 encode and decode it
		String f54928 = e54928.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54928); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
