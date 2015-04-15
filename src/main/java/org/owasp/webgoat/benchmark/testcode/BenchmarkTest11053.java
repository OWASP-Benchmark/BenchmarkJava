package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11053")
public class BenchmarkTest11053 extends HttpServlet {
	
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
		String a13317 = param; //assign
		StringBuilder b13317 = new StringBuilder(a13317);  // stick in stringbuilder
		b13317.append(" SafeStuff"); // append some safe content
		b13317.replace(b13317.length()-"Chars".length(),b13317.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13317 = new java.util.HashMap<String,Object>();
		map13317.put("key13317", b13317.toString()); // put in a collection
		String c13317 = (String)map13317.get("key13317"); // get it back out
		String d13317 = c13317.substring(0,c13317.length()-1); // extract most of it
		String e13317 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13317.getBytes() ) )); // B64 encode and decode it
		String f13317 = e13317.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g13317 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g13317); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
