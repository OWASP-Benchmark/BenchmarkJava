package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13249")
public class BenchmarkTest13249 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66055 = param; //assign
		StringBuilder b66055 = new StringBuilder(a66055);  // stick in stringbuilder
		b66055.append(" SafeStuff"); // append some safe content
		b66055.replace(b66055.length()-"Chars".length(),b66055.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66055 = new java.util.HashMap<String,Object>();
		map66055.put("key66055", b66055.toString()); // put in a collection
		String c66055 = (String)map66055.get("key66055"); // get it back out
		String d66055 = c66055.substring(0,c66055.length()-1); // extract most of it
		String e66055 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66055.getBytes() ) )); // B64 encode and decode it
		String f66055 = e66055.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f66055); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
