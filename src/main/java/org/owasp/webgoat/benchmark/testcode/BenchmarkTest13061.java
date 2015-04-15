package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13061")
public class BenchmarkTest13061 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79778 = param; //assign
		StringBuilder b79778 = new StringBuilder(a79778);  // stick in stringbuilder
		b79778.append(" SafeStuff"); // append some safe content
		b79778.replace(b79778.length()-"Chars".length(),b79778.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79778 = new java.util.HashMap<String,Object>();
		map79778.put("key79778", b79778.toString()); // put in a collection
		String c79778 = (String)map79778.get("key79778"); // get it back out
		String d79778 = c79778.substring(0,c79778.length()-1); // extract most of it
		String e79778 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79778.getBytes() ) )); // B64 encode and decode it
		String f79778 = e79778.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g79778 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g79778); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
