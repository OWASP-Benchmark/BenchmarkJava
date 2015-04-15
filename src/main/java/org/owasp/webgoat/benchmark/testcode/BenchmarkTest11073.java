package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11073")
public class BenchmarkTest11073 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45244 = param; //assign
		StringBuilder b45244 = new StringBuilder(a45244);  // stick in stringbuilder
		b45244.append(" SafeStuff"); // append some safe content
		b45244.replace(b45244.length()-"Chars".length(),b45244.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45244 = new java.util.HashMap<String,Object>();
		map45244.put("key45244", b45244.toString()); // put in a collection
		String c45244 = (String)map45244.get("key45244"); // get it back out
		String d45244 = c45244.substring(0,c45244.length()-1); // extract most of it
		String e45244 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45244.getBytes() ) )); // B64 encode and decode it
		String f45244 = e45244.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45244 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45244); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
