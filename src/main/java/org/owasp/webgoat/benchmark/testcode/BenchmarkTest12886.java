package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12886")
public class BenchmarkTest12886 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a91322 = param; //assign
		StringBuilder b91322 = new StringBuilder(a91322);  // stick in stringbuilder
		b91322.append(" SafeStuff"); // append some safe content
		b91322.replace(b91322.length()-"Chars".length(),b91322.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91322 = new java.util.HashMap<String,Object>();
		map91322.put("key91322", b91322.toString()); // put in a collection
		String c91322 = (String)map91322.get("key91322"); // get it back out
		String d91322 = c91322.substring(0,c91322.length()-1); // extract most of it
		String e91322 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91322.getBytes() ) )); // B64 encode and decode it
		String f91322 = e91322.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g91322 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91322); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
