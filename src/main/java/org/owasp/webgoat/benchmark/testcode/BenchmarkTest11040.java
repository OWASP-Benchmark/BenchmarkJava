package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11040")
public class BenchmarkTest11040 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
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
		String a41999 = param; //assign
		StringBuilder b41999 = new StringBuilder(a41999);  // stick in stringbuilder
		b41999.append(" SafeStuff"); // append some safe content
		b41999.replace(b41999.length()-"Chars".length(),b41999.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41999 = new java.util.HashMap<String,Object>();
		map41999.put("key41999", b41999.toString()); // put in a collection
		String c41999 = (String)map41999.get("key41999"); // get it back out
		String d41999 = c41999.substring(0,c41999.length()-1); // extract most of it
		String e41999 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41999.getBytes() ) )); // B64 encode and decode it
		String f41999 = e41999.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41999); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
