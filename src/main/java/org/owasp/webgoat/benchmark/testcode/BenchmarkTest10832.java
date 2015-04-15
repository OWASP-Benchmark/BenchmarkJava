package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10832")
public class BenchmarkTest10832 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a56298 = param; //assign
		StringBuilder b56298 = new StringBuilder(a56298);  // stick in stringbuilder
		b56298.append(" SafeStuff"); // append some safe content
		b56298.replace(b56298.length()-"Chars".length(),b56298.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56298 = new java.util.HashMap<String,Object>();
		map56298.put("key56298", b56298.toString()); // put in a collection
		String c56298 = (String)map56298.get("key56298"); // get it back out
		String d56298 = c56298.substring(0,c56298.length()-1); // extract most of it
		String e56298 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56298.getBytes() ) )); // B64 encode and decode it
		String f56298 = e56298.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g56298 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g56298); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
