package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12872")
public class BenchmarkTest12872 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a30044 = param; //assign
		StringBuilder b30044 = new StringBuilder(a30044);  // stick in stringbuilder
		b30044.append(" SafeStuff"); // append some safe content
		b30044.replace(b30044.length()-"Chars".length(),b30044.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30044 = new java.util.HashMap<String,Object>();
		map30044.put("key30044", b30044.toString()); // put in a collection
		String c30044 = (String)map30044.get("key30044"); // get it back out
		String d30044 = c30044.substring(0,c30044.length()-1); // extract most of it
		String e30044 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30044.getBytes() ) )); // B64 encode and decode it
		String f30044 = e30044.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g30044 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g30044); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
