package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09280")
public class BenchmarkTest09280 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a74405 = param; //assign
		StringBuilder b74405 = new StringBuilder(a74405);  // stick in stringbuilder
		b74405.append(" SafeStuff"); // append some safe content
		b74405.replace(b74405.length()-"Chars".length(),b74405.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map74405 = new java.util.HashMap<String,Object>();
		map74405.put("key74405", b74405.toString()); // put in a collection
		String c74405 = (String)map74405.get("key74405"); // get it back out
		String d74405 = c74405.substring(0,c74405.length()-1); // extract most of it
		String e74405 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d74405.getBytes() ) )); // B64 encode and decode it
		String f74405 = e74405.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g74405 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g74405); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
