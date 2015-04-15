package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10378")
public class BenchmarkTest10378 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37563 = param; //assign
		StringBuilder b37563 = new StringBuilder(a37563);  // stick in stringbuilder
		b37563.append(" SafeStuff"); // append some safe content
		b37563.replace(b37563.length()-"Chars".length(),b37563.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37563 = new java.util.HashMap<String,Object>();
		map37563.put("key37563", b37563.toString()); // put in a collection
		String c37563 = (String)map37563.get("key37563"); // get it back out
		String d37563 = c37563.substring(0,c37563.length()-1); // extract most of it
		String e37563 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37563.getBytes() ) )); // B64 encode and decode it
		String f37563 = e37563.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f37563); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
