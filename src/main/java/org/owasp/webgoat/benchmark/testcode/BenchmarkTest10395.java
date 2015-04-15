package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10395")
public class BenchmarkTest10395 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30505 = param; //assign
		StringBuilder b30505 = new StringBuilder(a30505);  // stick in stringbuilder
		b30505.append(" SafeStuff"); // append some safe content
		b30505.replace(b30505.length()-"Chars".length(),b30505.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30505 = new java.util.HashMap<String,Object>();
		map30505.put("key30505", b30505.toString()); // put in a collection
		String c30505 = (String)map30505.get("key30505"); // get it back out
		String d30505 = c30505.substring(0,c30505.length()-1); // extract most of it
		String e30505 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30505.getBytes() ) )); // B64 encode and decode it
		String f30505 = e30505.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30505); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
