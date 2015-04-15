package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07821")
public class BenchmarkTest07821 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50600 = param; //assign
		StringBuilder b50600 = new StringBuilder(a50600);  // stick in stringbuilder
		b50600.append(" SafeStuff"); // append some safe content
		b50600.replace(b50600.length()-"Chars".length(),b50600.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50600 = new java.util.HashMap<String,Object>();
		map50600.put("key50600", b50600.toString()); // put in a collection
		String c50600 = (String)map50600.get("key50600"); // get it back out
		String d50600 = c50600.substring(0,c50600.length()-1); // extract most of it
		String e50600 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50600.getBytes() ) )); // B64 encode and decode it
		String f50600 = e50600.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g50600 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g50600); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
