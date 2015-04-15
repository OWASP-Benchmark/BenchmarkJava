package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10604")
public class BenchmarkTest10604 extends HttpServlet {
	
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
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98540 = param; //assign
		StringBuilder b98540 = new StringBuilder(a98540);  // stick in stringbuilder
		b98540.append(" SafeStuff"); // append some safe content
		b98540.replace(b98540.length()-"Chars".length(),b98540.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98540 = new java.util.HashMap<String,Object>();
		map98540.put("key98540", b98540.toString()); // put in a collection
		String c98540 = (String)map98540.get("key98540"); // get it back out
		String d98540 = c98540.substring(0,c98540.length()-1); // extract most of it
		String e98540 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98540.getBytes() ) )); // B64 encode and decode it
		String f98540 = e98540.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g98540 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g98540); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
