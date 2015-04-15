package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10587")
public class BenchmarkTest10587 extends HttpServlet {
	
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
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a21991 = param; //assign
		StringBuilder b21991 = new StringBuilder(a21991);  // stick in stringbuilder
		b21991.append(" SafeStuff"); // append some safe content
		b21991.replace(b21991.length()-"Chars".length(),b21991.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21991 = new java.util.HashMap<String,Object>();
		map21991.put("key21991", b21991.toString()); // put in a collection
		String c21991 = (String)map21991.get("key21991"); // get it back out
		String d21991 = c21991.substring(0,c21991.length()-1); // extract most of it
		String e21991 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21991.getBytes() ) )); // B64 encode and decode it
		String f21991 = e21991.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g21991 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21991); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
