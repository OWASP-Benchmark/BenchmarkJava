package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10562")
public class BenchmarkTest10562 extends HttpServlet {
	
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
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68152 = param; //assign
		StringBuilder b68152 = new StringBuilder(a68152);  // stick in stringbuilder
		b68152.append(" SafeStuff"); // append some safe content
		b68152.replace(b68152.length()-"Chars".length(),b68152.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68152 = new java.util.HashMap<String,Object>();
		map68152.put("key68152", b68152.toString()); // put in a collection
		String c68152 = (String)map68152.get("key68152"); // get it back out
		String d68152 = c68152.substring(0,c68152.length()-1); // extract most of it
		String e68152 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68152.getBytes() ) )); // B64 encode and decode it
		String f68152 = e68152.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g68152 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g68152); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
