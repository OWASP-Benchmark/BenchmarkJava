package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09174")
public class BenchmarkTest09174 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77090 = param; //assign
		StringBuilder b77090 = new StringBuilder(a77090);  // stick in stringbuilder
		b77090.append(" SafeStuff"); // append some safe content
		b77090.replace(b77090.length()-"Chars".length(),b77090.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77090 = new java.util.HashMap<String,Object>();
		map77090.put("key77090", b77090.toString()); // put in a collection
		String c77090 = (String)map77090.get("key77090"); // get it back out
		String d77090 = c77090.substring(0,c77090.length()-1); // extract most of it
		String e77090 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77090.getBytes() ) )); // B64 encode and decode it
		String f77090 = e77090.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g77090 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77090); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
