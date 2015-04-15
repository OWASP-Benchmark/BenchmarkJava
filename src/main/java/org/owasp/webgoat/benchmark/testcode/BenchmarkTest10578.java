package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10578")
public class BenchmarkTest10578 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a12490 = param; //assign
		StringBuilder b12490 = new StringBuilder(a12490);  // stick in stringbuilder
		b12490.append(" SafeStuff"); // append some safe content
		b12490.replace(b12490.length()-"Chars".length(),b12490.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12490 = new java.util.HashMap<String,Object>();
		map12490.put("key12490", b12490.toString()); // put in a collection
		String c12490 = (String)map12490.get("key12490"); // get it back out
		String d12490 = c12490.substring(0,c12490.length()-1); // extract most of it
		String e12490 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12490.getBytes() ) )); // B64 encode and decode it
		String f12490 = e12490.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f12490); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
