package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10999")
public class BenchmarkTest10999 extends HttpServlet {
	
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
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21407 = param; //assign
		StringBuilder b21407 = new StringBuilder(a21407);  // stick in stringbuilder
		b21407.append(" SafeStuff"); // append some safe content
		b21407.replace(b21407.length()-"Chars".length(),b21407.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21407 = new java.util.HashMap<String,Object>();
		map21407.put("key21407", b21407.toString()); // put in a collection
		String c21407 = (String)map21407.get("key21407"); // get it back out
		String d21407 = c21407.substring(0,c21407.length()-1); // extract most of it
		String e21407 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21407.getBytes() ) )); // B64 encode and decode it
		String f21407 = e21407.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21407); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
