package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10681")
public class BenchmarkTest10681 extends HttpServlet {
	
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
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73525 = param; //assign
		StringBuilder b73525 = new StringBuilder(a73525);  // stick in stringbuilder
		b73525.append(" SafeStuff"); // append some safe content
		b73525.replace(b73525.length()-"Chars".length(),b73525.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73525 = new java.util.HashMap<String,Object>();
		map73525.put("key73525", b73525.toString()); // put in a collection
		String c73525 = (String)map73525.get("key73525"); // get it back out
		String d73525 = c73525.substring(0,c73525.length()-1); // extract most of it
		String e73525 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73525.getBytes() ) )); // B64 encode and decode it
		String f73525 = e73525.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73525 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73525); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
