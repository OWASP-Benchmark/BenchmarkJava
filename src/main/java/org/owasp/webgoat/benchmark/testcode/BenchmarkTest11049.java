package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11049")
public class BenchmarkTest11049 extends HttpServlet {
	
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
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40200 = param; //assign
		StringBuilder b40200 = new StringBuilder(a40200);  // stick in stringbuilder
		b40200.append(" SafeStuff"); // append some safe content
		b40200.replace(b40200.length()-"Chars".length(),b40200.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40200 = new java.util.HashMap<String,Object>();
		map40200.put("key40200", b40200.toString()); // put in a collection
		String c40200 = (String)map40200.get("key40200"); // get it back out
		String d40200 = c40200.substring(0,c40200.length()-1); // extract most of it
		String e40200 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40200.getBytes() ) )); // B64 encode and decode it
		String f40200 = e40200.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40200); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
