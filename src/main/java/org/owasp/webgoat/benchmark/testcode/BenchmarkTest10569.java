package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10569")
public class BenchmarkTest10569 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64416 = param; //assign
		StringBuilder b64416 = new StringBuilder(a64416);  // stick in stringbuilder
		b64416.append(" SafeStuff"); // append some safe content
		b64416.replace(b64416.length()-"Chars".length(),b64416.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64416 = new java.util.HashMap<String,Object>();
		map64416.put("key64416", b64416.toString()); // put in a collection
		String c64416 = (String)map64416.get("key64416"); // get it back out
		String d64416 = c64416.substring(0,c64416.length()-1); // extract most of it
		String e64416 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64416.getBytes() ) )); // B64 encode and decode it
		String f64416 = e64416.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64416 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64416); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
