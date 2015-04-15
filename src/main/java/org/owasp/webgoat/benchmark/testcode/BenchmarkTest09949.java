package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09949")
public class BenchmarkTest09949 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a54971 = param; //assign
		StringBuilder b54971 = new StringBuilder(a54971);  // stick in stringbuilder
		b54971.append(" SafeStuff"); // append some safe content
		b54971.replace(b54971.length()-"Chars".length(),b54971.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54971 = new java.util.HashMap<String,Object>();
		map54971.put("key54971", b54971.toString()); // put in a collection
		String c54971 = (String)map54971.get("key54971"); // get it back out
		String d54971 = c54971.substring(0,c54971.length()-1); // extract most of it
		String e54971 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54971.getBytes() ) )); // B64 encode and decode it
		String f54971 = e54971.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g54971 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g54971); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
