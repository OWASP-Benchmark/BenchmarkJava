package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10419")
public class BenchmarkTest10419 extends HttpServlet {
	
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
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4094 = param; //assign
		StringBuilder b4094 = new StringBuilder(a4094);  // stick in stringbuilder
		b4094.append(" SafeStuff"); // append some safe content
		b4094.replace(b4094.length()-"Chars".length(),b4094.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4094 = new java.util.HashMap<String,Object>();
		map4094.put("key4094", b4094.toString()); // put in a collection
		String c4094 = (String)map4094.get("key4094"); // get it back out
		String d4094 = c4094.substring(0,c4094.length()-1); // extract most of it
		String e4094 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4094.getBytes() ) )); // B64 encode and decode it
		String f4094 = e4094.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4094); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
