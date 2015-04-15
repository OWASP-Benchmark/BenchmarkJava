package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10997")
public class BenchmarkTest10997 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

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
		String a51632 = param; //assign
		StringBuilder b51632 = new StringBuilder(a51632);  // stick in stringbuilder
		b51632.append(" SafeStuff"); // append some safe content
		b51632.replace(b51632.length()-"Chars".length(),b51632.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51632 = new java.util.HashMap<String,Object>();
		map51632.put("key51632", b51632.toString()); // put in a collection
		String c51632 = (String)map51632.get("key51632"); // get it back out
		String d51632 = c51632.substring(0,c51632.length()-1); // extract most of it
		String e51632 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51632.getBytes() ) )); // B64 encode and decode it
		String f51632 = e51632.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51632); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
