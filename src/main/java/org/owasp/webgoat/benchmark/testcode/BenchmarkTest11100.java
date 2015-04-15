package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11100")
public class BenchmarkTest11100 extends HttpServlet {
	
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
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7129 = param; //assign
		StringBuilder b7129 = new StringBuilder(a7129);  // stick in stringbuilder
		b7129.append(" SafeStuff"); // append some safe content
		b7129.replace(b7129.length()-"Chars".length(),b7129.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7129 = new java.util.HashMap<String,Object>();
		map7129.put("key7129", b7129.toString()); // put in a collection
		String c7129 = (String)map7129.get("key7129"); // get it back out
		String d7129 = c7129.substring(0,c7129.length()-1); // extract most of it
		String e7129 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7129.getBytes() ) )); // B64 encode and decode it
		String f7129 = e7129.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f7129); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
