package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13012")
public class BenchmarkTest13012 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95451 = param; //assign
		StringBuilder b95451 = new StringBuilder(a95451);  // stick in stringbuilder
		b95451.append(" SafeStuff"); // append some safe content
		b95451.replace(b95451.length()-"Chars".length(),b95451.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95451 = new java.util.HashMap<String,Object>();
		map95451.put("key95451", b95451.toString()); // put in a collection
		String c95451 = (String)map95451.get("key95451"); // get it back out
		String d95451 = c95451.substring(0,c95451.length()-1); // extract most of it
		String e95451 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95451.getBytes() ) )); // B64 encode and decode it
		String f95451 = e95451.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95451 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95451); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
