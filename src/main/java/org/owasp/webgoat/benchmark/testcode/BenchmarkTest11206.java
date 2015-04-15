package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11206")
public class BenchmarkTest11206 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a42248 = param; //assign
		StringBuilder b42248 = new StringBuilder(a42248);  // stick in stringbuilder
		b42248.append(" SafeStuff"); // append some safe content
		b42248.replace(b42248.length()-"Chars".length(),b42248.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map42248 = new java.util.HashMap<String,Object>();
		map42248.put("key42248", b42248.toString()); // put in a collection
		String c42248 = (String)map42248.get("key42248"); // get it back out
		String d42248 = c42248.substring(0,c42248.length()-1); // extract most of it
		String e42248 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d42248.getBytes() ) )); // B64 encode and decode it
		String f42248 = e42248.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g42248 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g42248); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
