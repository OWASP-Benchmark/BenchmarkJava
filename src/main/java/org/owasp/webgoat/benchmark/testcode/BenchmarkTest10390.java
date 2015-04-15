package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10390")
public class BenchmarkTest10390 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52251 = param; //assign
		StringBuilder b52251 = new StringBuilder(a52251);  // stick in stringbuilder
		b52251.append(" SafeStuff"); // append some safe content
		b52251.replace(b52251.length()-"Chars".length(),b52251.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52251 = new java.util.HashMap<String,Object>();
		map52251.put("key52251", b52251.toString()); // put in a collection
		String c52251 = (String)map52251.get("key52251"); // get it back out
		String d52251 = c52251.substring(0,c52251.length()-1); // extract most of it
		String e52251 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52251.getBytes() ) )); // B64 encode and decode it
		String f52251 = e52251.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52251 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52251); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
