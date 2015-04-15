package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10365")
public class BenchmarkTest10365 extends HttpServlet {
	
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
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a65485 = param; //assign
		StringBuilder b65485 = new StringBuilder(a65485);  // stick in stringbuilder
		b65485.append(" SafeStuff"); // append some safe content
		b65485.replace(b65485.length()-"Chars".length(),b65485.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65485 = new java.util.HashMap<String,Object>();
		map65485.put("key65485", b65485.toString()); // put in a collection
		String c65485 = (String)map65485.get("key65485"); // get it back out
		String d65485 = c65485.substring(0,c65485.length()-1); // extract most of it
		String e65485 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65485.getBytes() ) )); // B64 encode and decode it
		String f65485 = e65485.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f65485); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
