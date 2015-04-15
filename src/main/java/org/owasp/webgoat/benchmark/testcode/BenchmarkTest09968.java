package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09968")
public class BenchmarkTest09968 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93436 = param; //assign
		StringBuilder b93436 = new StringBuilder(a93436);  // stick in stringbuilder
		b93436.append(" SafeStuff"); // append some safe content
		b93436.replace(b93436.length()-"Chars".length(),b93436.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93436 = new java.util.HashMap<String,Object>();
		map93436.put("key93436", b93436.toString()); // put in a collection
		String c93436 = (String)map93436.get("key93436"); // get it back out
		String d93436 = c93436.substring(0,c93436.length()-1); // extract most of it
		String e93436 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93436.getBytes() ) )); // B64 encode and decode it
		String f93436 = e93436.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93436 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93436); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
