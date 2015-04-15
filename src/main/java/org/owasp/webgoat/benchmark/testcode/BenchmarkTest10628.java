package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10628")
public class BenchmarkTest10628 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4151 = param; //assign
		StringBuilder b4151 = new StringBuilder(a4151);  // stick in stringbuilder
		b4151.append(" SafeStuff"); // append some safe content
		b4151.replace(b4151.length()-"Chars".length(),b4151.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4151 = new java.util.HashMap<String,Object>();
		map4151.put("key4151", b4151.toString()); // put in a collection
		String c4151 = (String)map4151.get("key4151"); // get it back out
		String d4151 = c4151.substring(0,c4151.length()-1); // extract most of it
		String e4151 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4151.getBytes() ) )); // B64 encode and decode it
		String f4151 = e4151.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g4151 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g4151); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
