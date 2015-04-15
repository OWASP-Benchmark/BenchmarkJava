package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10373")
public class BenchmarkTest10373 extends HttpServlet {
	
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
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a1535 = param; //assign
		StringBuilder b1535 = new StringBuilder(a1535);  // stick in stringbuilder
		b1535.append(" SafeStuff"); // append some safe content
		b1535.replace(b1535.length()-"Chars".length(),b1535.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map1535 = new java.util.HashMap<String,Object>();
		map1535.put("key1535", b1535.toString()); // put in a collection
		String c1535 = (String)map1535.get("key1535"); // get it back out
		String d1535 = c1535.substring(0,c1535.length()-1); // extract most of it
		String e1535 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d1535.getBytes() ) )); // B64 encode and decode it
		String f1535 = e1535.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f1535); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
