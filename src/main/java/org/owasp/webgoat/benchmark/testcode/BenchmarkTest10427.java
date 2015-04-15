package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10427")
public class BenchmarkTest10427 extends HttpServlet {
	
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
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a57249 = param; //assign
		StringBuilder b57249 = new StringBuilder(a57249);  // stick in stringbuilder
		b57249.append(" SafeStuff"); // append some safe content
		b57249.replace(b57249.length()-"Chars".length(),b57249.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57249 = new java.util.HashMap<String,Object>();
		map57249.put("key57249", b57249.toString()); // put in a collection
		String c57249 = (String)map57249.get("key57249"); // get it back out
		String d57249 = c57249.substring(0,c57249.length()-1); // extract most of it
		String e57249 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57249.getBytes() ) )); // B64 encode and decode it
		String f57249 = e57249.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57249); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
