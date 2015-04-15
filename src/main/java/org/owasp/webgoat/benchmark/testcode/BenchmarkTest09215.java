package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09215")
public class BenchmarkTest09215 extends HttpServlet {
	
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
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8251 = param; //assign
		StringBuilder b8251 = new StringBuilder(a8251);  // stick in stringbuilder
		b8251.append(" SafeStuff"); // append some safe content
		b8251.replace(b8251.length()-"Chars".length(),b8251.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8251 = new java.util.HashMap<String,Object>();
		map8251.put("key8251", b8251.toString()); // put in a collection
		String c8251 = (String)map8251.get("key8251"); // get it back out
		String d8251 = c8251.substring(0,c8251.length()-1); // extract most of it
		String e8251 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8251.getBytes() ) )); // B64 encode and decode it
		String f8251 = e8251.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g8251 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g8251); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
