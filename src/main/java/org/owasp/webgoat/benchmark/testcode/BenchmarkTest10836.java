package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10836")
public class BenchmarkTest10836 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88735 = param; //assign
		StringBuilder b88735 = new StringBuilder(a88735);  // stick in stringbuilder
		b88735.append(" SafeStuff"); // append some safe content
		b88735.replace(b88735.length()-"Chars".length(),b88735.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88735 = new java.util.HashMap<String,Object>();
		map88735.put("key88735", b88735.toString()); // put in a collection
		String c88735 = (String)map88735.get("key88735"); // get it back out
		String d88735 = c88735.substring(0,c88735.length()-1); // extract most of it
		String e88735 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88735.getBytes() ) )); // B64 encode and decode it
		String f88735 = e88735.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g88735 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88735); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
