package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10610")
public class BenchmarkTest10610 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64814 = param; //assign
		StringBuilder b64814 = new StringBuilder(a64814);  // stick in stringbuilder
		b64814.append(" SafeStuff"); // append some safe content
		b64814.replace(b64814.length()-"Chars".length(),b64814.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64814 = new java.util.HashMap<String,Object>();
		map64814.put("key64814", b64814.toString()); // put in a collection
		String c64814 = (String)map64814.get("key64814"); // get it back out
		String d64814 = c64814.substring(0,c64814.length()-1); // extract most of it
		String e64814 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64814.getBytes() ) )); // B64 encode and decode it
		String f64814 = e64814.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64814); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
