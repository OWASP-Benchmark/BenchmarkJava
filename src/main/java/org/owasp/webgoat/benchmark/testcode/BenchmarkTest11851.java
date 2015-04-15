package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11851")
public class BenchmarkTest11851 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a51347 = param; //assign
		StringBuilder b51347 = new StringBuilder(a51347);  // stick in stringbuilder
		b51347.append(" SafeStuff"); // append some safe content
		b51347.replace(b51347.length()-"Chars".length(),b51347.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51347 = new java.util.HashMap<String,Object>();
		map51347.put("key51347", b51347.toString()); // put in a collection
		String c51347 = (String)map51347.get("key51347"); // get it back out
		String d51347 = c51347.substring(0,c51347.length()-1); // extract most of it
		String e51347 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51347.getBytes() ) )); // B64 encode and decode it
		String f51347 = e51347.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g51347 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g51347); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
