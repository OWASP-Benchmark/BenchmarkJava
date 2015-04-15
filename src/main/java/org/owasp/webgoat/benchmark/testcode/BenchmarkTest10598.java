package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10598")
public class BenchmarkTest10598 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86623 = param; //assign
		StringBuilder b86623 = new StringBuilder(a86623);  // stick in stringbuilder
		b86623.append(" SafeStuff"); // append some safe content
		b86623.replace(b86623.length()-"Chars".length(),b86623.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86623 = new java.util.HashMap<String,Object>();
		map86623.put("key86623", b86623.toString()); // put in a collection
		String c86623 = (String)map86623.get("key86623"); // get it back out
		String d86623 = c86623.substring(0,c86623.length()-1); // extract most of it
		String e86623 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86623.getBytes() ) )); // B64 encode and decode it
		String f86623 = e86623.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86623 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86623); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
