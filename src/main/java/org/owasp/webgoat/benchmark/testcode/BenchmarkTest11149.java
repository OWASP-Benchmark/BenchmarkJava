package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11149")
public class BenchmarkTest11149 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38335 = param; //assign
		StringBuilder b38335 = new StringBuilder(a38335);  // stick in stringbuilder
		b38335.append(" SafeStuff"); // append some safe content
		b38335.replace(b38335.length()-"Chars".length(),b38335.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38335 = new java.util.HashMap<String,Object>();
		map38335.put("key38335", b38335.toString()); // put in a collection
		String c38335 = (String)map38335.get("key38335"); // get it back out
		String d38335 = c38335.substring(0,c38335.length()-1); // extract most of it
		String e38335 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38335.getBytes() ) )); // B64 encode and decode it
		String f38335 = e38335.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g38335 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g38335); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
