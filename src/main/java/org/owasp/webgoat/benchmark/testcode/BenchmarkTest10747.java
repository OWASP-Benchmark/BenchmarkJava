package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10747")
public class BenchmarkTest10747 extends HttpServlet {
	
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
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50751 = param; //assign
		StringBuilder b50751 = new StringBuilder(a50751);  // stick in stringbuilder
		b50751.append(" SafeStuff"); // append some safe content
		b50751.replace(b50751.length()-"Chars".length(),b50751.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50751 = new java.util.HashMap<String,Object>();
		map50751.put("key50751", b50751.toString()); // put in a collection
		String c50751 = (String)map50751.get("key50751"); // get it back out
		String d50751 = c50751.substring(0,c50751.length()-1); // extract most of it
		String e50751 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50751.getBytes() ) )); // B64 encode and decode it
		String f50751 = e50751.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g50751 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g50751); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
