package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11178")
public class BenchmarkTest11178 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95868 = param; //assign
		StringBuilder b95868 = new StringBuilder(a95868);  // stick in stringbuilder
		b95868.append(" SafeStuff"); // append some safe content
		b95868.replace(b95868.length()-"Chars".length(),b95868.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95868 = new java.util.HashMap<String,Object>();
		map95868.put("key95868", b95868.toString()); // put in a collection
		String c95868 = (String)map95868.get("key95868"); // get it back out
		String d95868 = c95868.substring(0,c95868.length()-1); // extract most of it
		String e95868 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95868.getBytes() ) )); // B64 encode and decode it
		String f95868 = e95868.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95868 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95868); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
