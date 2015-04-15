package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10522")
public class BenchmarkTest10522 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30385 = param; //assign
		StringBuilder b30385 = new StringBuilder(a30385);  // stick in stringbuilder
		b30385.append(" SafeStuff"); // append some safe content
		b30385.replace(b30385.length()-"Chars".length(),b30385.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30385 = new java.util.HashMap<String,Object>();
		map30385.put("key30385", b30385.toString()); // put in a collection
		String c30385 = (String)map30385.get("key30385"); // get it back out
		String d30385 = c30385.substring(0,c30385.length()-1); // extract most of it
		String e30385 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30385.getBytes() ) )); // B64 encode and decode it
		String f30385 = e30385.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g30385 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g30385); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
