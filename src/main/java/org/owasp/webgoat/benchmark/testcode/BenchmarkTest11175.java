package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11175")
public class BenchmarkTest11175 extends HttpServlet {
	
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
		String a38071 = param; //assign
		StringBuilder b38071 = new StringBuilder(a38071);  // stick in stringbuilder
		b38071.append(" SafeStuff"); // append some safe content
		b38071.replace(b38071.length()-"Chars".length(),b38071.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38071 = new java.util.HashMap<String,Object>();
		map38071.put("key38071", b38071.toString()); // put in a collection
		String c38071 = (String)map38071.get("key38071"); // get it back out
		String d38071 = c38071.substring(0,c38071.length()-1); // extract most of it
		String e38071 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38071.getBytes() ) )); // B64 encode and decode it
		String f38071 = e38071.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38071); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
