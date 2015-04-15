package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10619")
public class BenchmarkTest10619 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76118 = param; //assign
		StringBuilder b76118 = new StringBuilder(a76118);  // stick in stringbuilder
		b76118.append(" SafeStuff"); // append some safe content
		b76118.replace(b76118.length()-"Chars".length(),b76118.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76118 = new java.util.HashMap<String,Object>();
		map76118.put("key76118", b76118.toString()); // put in a collection
		String c76118 = (String)map76118.get("key76118"); // get it back out
		String d76118 = c76118.substring(0,c76118.length()-1); // extract most of it
		String e76118 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76118.getBytes() ) )); // B64 encode and decode it
		String f76118 = e76118.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76118 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76118); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
