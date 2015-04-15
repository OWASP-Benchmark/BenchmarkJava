package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10707")
public class BenchmarkTest10707 extends HttpServlet {
	
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
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8881 = param; //assign
		StringBuilder b8881 = new StringBuilder(a8881);  // stick in stringbuilder
		b8881.append(" SafeStuff"); // append some safe content
		b8881.replace(b8881.length()-"Chars".length(),b8881.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8881 = new java.util.HashMap<String,Object>();
		map8881.put("key8881", b8881.toString()); // put in a collection
		String c8881 = (String)map8881.get("key8881"); // get it back out
		String d8881 = c8881.substring(0,c8881.length()-1); // extract most of it
		String e8881 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8881.getBytes() ) )); // B64 encode and decode it
		String f8881 = e8881.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f8881); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
