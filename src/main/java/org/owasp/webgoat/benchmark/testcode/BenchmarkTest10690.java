package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10690")
public class BenchmarkTest10690 extends HttpServlet {
	
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
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98851 = param; //assign
		StringBuilder b98851 = new StringBuilder(a98851);  // stick in stringbuilder
		b98851.append(" SafeStuff"); // append some safe content
		b98851.replace(b98851.length()-"Chars".length(),b98851.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98851 = new java.util.HashMap<String,Object>();
		map98851.put("key98851", b98851.toString()); // put in a collection
		String c98851 = (String)map98851.get("key98851"); // get it back out
		String d98851 = c98851.substring(0,c98851.length()-1); // extract most of it
		String e98851 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98851.getBytes() ) )); // B64 encode and decode it
		String f98851 = e98851.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g98851 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g98851); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
