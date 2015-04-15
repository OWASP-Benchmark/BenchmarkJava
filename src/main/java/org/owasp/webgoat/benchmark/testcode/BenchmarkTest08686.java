package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08686")
public class BenchmarkTest08686 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a7271 = param; //assign
		StringBuilder b7271 = new StringBuilder(a7271);  // stick in stringbuilder
		b7271.append(" SafeStuff"); // append some safe content
		b7271.replace(b7271.length()-"Chars".length(),b7271.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map7271 = new java.util.HashMap<String,Object>();
		map7271.put("key7271", b7271.toString()); // put in a collection
		String c7271 = (String)map7271.get("key7271"); // get it back out
		String d7271 = c7271.substring(0,c7271.length()-1); // extract most of it
		String e7271 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d7271.getBytes() ) )); // B64 encode and decode it
		String f7271 = e7271.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g7271 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g7271); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
