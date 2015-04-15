package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09822")
public class BenchmarkTest09822 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58798 = param; //assign
		StringBuilder b58798 = new StringBuilder(a58798);  // stick in stringbuilder
		b58798.append(" SafeStuff"); // append some safe content
		b58798.replace(b58798.length()-"Chars".length(),b58798.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58798 = new java.util.HashMap<String,Object>();
		map58798.put("key58798", b58798.toString()); // put in a collection
		String c58798 = (String)map58798.get("key58798"); // get it back out
		String d58798 = c58798.substring(0,c58798.length()-1); // extract most of it
		String e58798 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58798.getBytes() ) )); // B64 encode and decode it
		String f58798 = e58798.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g58798 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g58798); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
