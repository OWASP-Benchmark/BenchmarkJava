package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10559")
public class BenchmarkTest10559 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a82050 = param; //assign
		StringBuilder b82050 = new StringBuilder(a82050);  // stick in stringbuilder
		b82050.append(" SafeStuff"); // append some safe content
		b82050.replace(b82050.length()-"Chars".length(),b82050.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82050 = new java.util.HashMap<String,Object>();
		map82050.put("key82050", b82050.toString()); // put in a collection
		String c82050 = (String)map82050.get("key82050"); // get it back out
		String d82050 = c82050.substring(0,c82050.length()-1); // extract most of it
		String e82050 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82050.getBytes() ) )); // B64 encode and decode it
		String f82050 = e82050.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82050); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
