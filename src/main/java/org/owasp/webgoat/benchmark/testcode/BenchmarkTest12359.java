package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12359")
public class BenchmarkTest12359 extends HttpServlet {
	
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
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70865 = param; //assign
		StringBuilder b70865 = new StringBuilder(a70865);  // stick in stringbuilder
		b70865.append(" SafeStuff"); // append some safe content
		b70865.replace(b70865.length()-"Chars".length(),b70865.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70865 = new java.util.HashMap<String,Object>();
		map70865.put("key70865", b70865.toString()); // put in a collection
		String c70865 = (String)map70865.get("key70865"); // get it back out
		String d70865 = c70865.substring(0,c70865.length()-1); // extract most of it
		String e70865 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70865.getBytes() ) )); // B64 encode and decode it
		String f70865 = e70865.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70865); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
