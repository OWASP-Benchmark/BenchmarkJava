package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10367")
public class BenchmarkTest10367 extends HttpServlet {
	
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
		String a55938 = param; //assign
		StringBuilder b55938 = new StringBuilder(a55938);  // stick in stringbuilder
		b55938.append(" SafeStuff"); // append some safe content
		b55938.replace(b55938.length()-"Chars".length(),b55938.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55938 = new java.util.HashMap<String,Object>();
		map55938.put("key55938", b55938.toString()); // put in a collection
		String c55938 = (String)map55938.get("key55938"); // get it back out
		String d55938 = c55938.substring(0,c55938.length()-1); // extract most of it
		String e55938 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55938.getBytes() ) )); // B64 encode and decode it
		String f55938 = e55938.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g55938 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55938); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
