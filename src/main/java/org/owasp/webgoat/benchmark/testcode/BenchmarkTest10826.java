package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10826")
public class BenchmarkTest10826 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8871 = param; //assign
		StringBuilder b8871 = new StringBuilder(a8871);  // stick in stringbuilder
		b8871.append(" SafeStuff"); // append some safe content
		b8871.replace(b8871.length()-"Chars".length(),b8871.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8871 = new java.util.HashMap<String,Object>();
		map8871.put("key8871", b8871.toString()); // put in a collection
		String c8871 = (String)map8871.get("key8871"); // get it back out
		String d8871 = c8871.substring(0,c8871.length()-1); // extract most of it
		String e8871 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8871.getBytes() ) )); // B64 encode and decode it
		String f8871 = e8871.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g8871 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g8871); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
