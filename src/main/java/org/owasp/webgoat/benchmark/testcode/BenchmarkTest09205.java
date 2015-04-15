package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09205")
public class BenchmarkTest09205 extends HttpServlet {
	
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
		String a66668 = param; //assign
		StringBuilder b66668 = new StringBuilder(a66668);  // stick in stringbuilder
		b66668.append(" SafeStuff"); // append some safe content
		b66668.replace(b66668.length()-"Chars".length(),b66668.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66668 = new java.util.HashMap<String,Object>();
		map66668.put("key66668", b66668.toString()); // put in a collection
		String c66668 = (String)map66668.get("key66668"); // get it back out
		String d66668 = c66668.substring(0,c66668.length()-1); // extract most of it
		String e66668 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66668.getBytes() ) )); // B64 encode and decode it
		String f66668 = e66668.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g66668 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g66668); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
