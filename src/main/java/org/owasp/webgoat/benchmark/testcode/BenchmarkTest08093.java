package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08093")
public class BenchmarkTest08093 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

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

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(args);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58331 = param; //assign
		StringBuilder b58331 = new StringBuilder(a58331);  // stick in stringbuilder
		b58331.append(" SafeStuff"); // append some safe content
		b58331.replace(b58331.length()-"Chars".length(),b58331.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58331 = new java.util.HashMap<String,Object>();
		map58331.put("key58331", b58331.toString()); // put in a collection
		String c58331 = (String)map58331.get("key58331"); // get it back out
		String d58331 = c58331.substring(0,c58331.length()-1); // extract most of it
		String e58331 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58331.getBytes() ) )); // B64 encode and decode it
		String f58331 = e58331.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58331); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
