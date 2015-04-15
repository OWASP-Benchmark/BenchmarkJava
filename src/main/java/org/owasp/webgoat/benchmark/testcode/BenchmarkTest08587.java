package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08587")
public class BenchmarkTest08587 extends HttpServlet {
	
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
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94669 = param; //assign
		StringBuilder b94669 = new StringBuilder(a94669);  // stick in stringbuilder
		b94669.append(" SafeStuff"); // append some safe content
		b94669.replace(b94669.length()-"Chars".length(),b94669.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94669 = new java.util.HashMap<String,Object>();
		map94669.put("key94669", b94669.toString()); // put in a collection
		String c94669 = (String)map94669.get("key94669"); // get it back out
		String d94669 = c94669.substring(0,c94669.length()-1); // extract most of it
		String e94669 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94669.getBytes() ) )); // B64 encode and decode it
		String f94669 = e94669.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g94669 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94669); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
