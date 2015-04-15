package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10753")
public class BenchmarkTest10753 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a18463 = param; //assign
		StringBuilder b18463 = new StringBuilder(a18463);  // stick in stringbuilder
		b18463.append(" SafeStuff"); // append some safe content
		b18463.replace(b18463.length()-"Chars".length(),b18463.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18463 = new java.util.HashMap<String,Object>();
		map18463.put("key18463", b18463.toString()); // put in a collection
		String c18463 = (String)map18463.get("key18463"); // get it back out
		String d18463 = c18463.substring(0,c18463.length()-1); // extract most of it
		String e18463 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18463.getBytes() ) )); // B64 encode and decode it
		String f18463 = e18463.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18463 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18463); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
