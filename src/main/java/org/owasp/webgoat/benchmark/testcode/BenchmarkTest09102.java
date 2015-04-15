package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09102")
public class BenchmarkTest09102 extends HttpServlet {
	
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
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66957 = param; //assign
		StringBuilder b66957 = new StringBuilder(a66957);  // stick in stringbuilder
		b66957.append(" SafeStuff"); // append some safe content
		b66957.replace(b66957.length()-"Chars".length(),b66957.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66957 = new java.util.HashMap<String,Object>();
		map66957.put("key66957", b66957.toString()); // put in a collection
		String c66957 = (String)map66957.get("key66957"); // get it back out
		String d66957 = c66957.substring(0,c66957.length()-1); // extract most of it
		String e66957 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66957.getBytes() ) )); // B64 encode and decode it
		String f66957 = e66957.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g66957 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g66957); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
