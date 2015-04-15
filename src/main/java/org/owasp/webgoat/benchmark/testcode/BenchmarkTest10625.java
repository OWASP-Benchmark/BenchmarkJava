package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10625")
public class BenchmarkTest10625 extends HttpServlet {
	
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
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a39776 = param; //assign
		StringBuilder b39776 = new StringBuilder(a39776);  // stick in stringbuilder
		b39776.append(" SafeStuff"); // append some safe content
		b39776.replace(b39776.length()-"Chars".length(),b39776.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map39776 = new java.util.HashMap<String,Object>();
		map39776.put("key39776", b39776.toString()); // put in a collection
		String c39776 = (String)map39776.get("key39776"); // get it back out
		String d39776 = c39776.substring(0,c39776.length()-1); // extract most of it
		String e39776 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d39776.getBytes() ) )); // B64 encode and decode it
		String f39776 = e39776.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f39776); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
