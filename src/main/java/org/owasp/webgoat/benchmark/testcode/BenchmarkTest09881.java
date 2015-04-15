package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09881")
public class BenchmarkTest09881 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93423 = param; //assign
		StringBuilder b93423 = new StringBuilder(a93423);  // stick in stringbuilder
		b93423.append(" SafeStuff"); // append some safe content
		b93423.replace(b93423.length()-"Chars".length(),b93423.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93423 = new java.util.HashMap<String,Object>();
		map93423.put("key93423", b93423.toString()); // put in a collection
		String c93423 = (String)map93423.get("key93423"); // get it back out
		String d93423 = c93423.substring(0,c93423.length()-1); // extract most of it
		String e93423 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93423.getBytes() ) )); // B64 encode and decode it
		String f93423 = e93423.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93423); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
