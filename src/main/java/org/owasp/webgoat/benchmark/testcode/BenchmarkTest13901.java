package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13901")
public class BenchmarkTest13901 extends HttpServlet {
	
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
		
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};
        
        String[] argsEnv = { "foo=bar" };
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29538 = param; //assign
		StringBuilder b29538 = new StringBuilder(a29538);  // stick in stringbuilder
		b29538.append(" SafeStuff"); // append some safe content
		b29538.replace(b29538.length()-"Chars".length(),b29538.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29538 = new java.util.HashMap<String,Object>();
		map29538.put("key29538", b29538.toString()); // put in a collection
		String c29538 = (String)map29538.get("key29538"); // get it back out
		String d29538 = c29538.substring(0,c29538.length()-1); // extract most of it
		String e29538 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29538.getBytes() ) )); // B64 encode and decode it
		String f29538 = e29538.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29538); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
