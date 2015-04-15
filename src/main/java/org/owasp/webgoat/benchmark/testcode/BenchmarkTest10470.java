package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10470")
public class BenchmarkTest10470 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
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
		String a2384 = param; //assign
		StringBuilder b2384 = new StringBuilder(a2384);  // stick in stringbuilder
		b2384.append(" SafeStuff"); // append some safe content
		b2384.replace(b2384.length()-"Chars".length(),b2384.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2384 = new java.util.HashMap<String,Object>();
		map2384.put("key2384", b2384.toString()); // put in a collection
		String c2384 = (String)map2384.get("key2384"); // get it back out
		String d2384 = c2384.substring(0,c2384.length()-1); // extract most of it
		String e2384 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2384.getBytes() ) )); // B64 encode and decode it
		String f2384 = e2384.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f2384); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
