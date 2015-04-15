package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11248")
public class BenchmarkTest11248 extends HttpServlet {
	
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
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93558 = param; //assign
		StringBuilder b93558 = new StringBuilder(a93558);  // stick in stringbuilder
		b93558.append(" SafeStuff"); // append some safe content
		b93558.replace(b93558.length()-"Chars".length(),b93558.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93558 = new java.util.HashMap<String,Object>();
		map93558.put("key93558", b93558.toString()); // put in a collection
		String c93558 = (String)map93558.get("key93558"); // get it back out
		String d93558 = c93558.substring(0,c93558.length()-1); // extract most of it
		String e93558 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93558.getBytes() ) )); // B64 encode and decode it
		String f93558 = e93558.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g93558 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93558); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
