package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13535")
public class BenchmarkTest13535 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		// Create the file first so the test won't throw an exception if it doesn't exist.
		// Note: Don't actually do this because this method signature could cause a tool to find THIS file constructor 
		// as a vuln, rather than the File signature we are trying to actually test.
		// If necessary, just run the benchmark twice. The 1st run should create all the necessary files.
		//new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar).createNewFile();
		


        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
        		org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
        java.io.FileDescriptor fd = fileInputStream.getFD();
        java.io.FileOutputStream anotOutputStream = new java.io.FileOutputStream(fd);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94462 = param; //assign
		StringBuilder b94462 = new StringBuilder(a94462);  // stick in stringbuilder
		b94462.append(" SafeStuff"); // append some safe content
		b94462.replace(b94462.length()-"Chars".length(),b94462.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94462 = new java.util.HashMap<String,Object>();
		map94462.put("key94462", b94462.toString()); // put in a collection
		String c94462 = (String)map94462.get("key94462"); // get it back out
		String d94462 = c94462.substring(0,c94462.length()-1); // extract most of it
		String e94462 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94462.getBytes() ) )); // B64 encode and decode it
		String f94462 = e94462.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g94462 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g94462); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
