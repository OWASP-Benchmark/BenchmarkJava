package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09997")
public class BenchmarkTest09997 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

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

		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20535 = param; //assign
		StringBuilder b20535 = new StringBuilder(a20535);  // stick in stringbuilder
		b20535.append(" SafeStuff"); // append some safe content
		b20535.replace(b20535.length()-"Chars".length(),b20535.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20535 = new java.util.HashMap<String,Object>();
		map20535.put("key20535", b20535.toString()); // put in a collection
		String c20535 = (String)map20535.get("key20535"); // get it back out
		String d20535 = c20535.substring(0,c20535.length()-1); // extract most of it
		String e20535 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20535.getBytes() ) )); // B64 encode and decode it
		String f20535 = e20535.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f20535); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
