package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10482")
public class BenchmarkTest10482 extends HttpServlet {
	
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
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19166 = param; //assign
		StringBuilder b19166 = new StringBuilder(a19166);  // stick in stringbuilder
		b19166.append(" SafeStuff"); // append some safe content
		b19166.replace(b19166.length()-"Chars".length(),b19166.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19166 = new java.util.HashMap<String,Object>();
		map19166.put("key19166", b19166.toString()); // put in a collection
		String c19166 = (String)map19166.get("key19166"); // get it back out
		String d19166 = c19166.substring(0,c19166.length()-1); // extract most of it
		String e19166 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19166.getBytes() ) )); // B64 encode and decode it
		String f19166 = e19166.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19166 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19166); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
