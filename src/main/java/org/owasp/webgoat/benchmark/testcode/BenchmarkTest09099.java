package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09099")
public class BenchmarkTest09099 extends HttpServlet {
	
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
		String a93757 = param; //assign
		StringBuilder b93757 = new StringBuilder(a93757);  // stick in stringbuilder
		b93757.append(" SafeStuff"); // append some safe content
		b93757.replace(b93757.length()-"Chars".length(),b93757.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93757 = new java.util.HashMap<String,Object>();
		map93757.put("key93757", b93757.toString()); // put in a collection
		String c93757 = (String)map93757.get("key93757"); // get it back out
		String d93757 = c93757.substring(0,c93757.length()-1); // extract most of it
		String e93757 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93757.getBytes() ) )); // B64 encode and decode it
		String f93757 = e93757.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93757); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
