package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13264")
public class BenchmarkTest13264 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a76869 = param; //assign
		StringBuilder b76869 = new StringBuilder(a76869);  // stick in stringbuilder
		b76869.append(" SafeStuff"); // append some safe content
		b76869.replace(b76869.length()-"Chars".length(),b76869.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76869 = new java.util.HashMap<String,Object>();
		map76869.put("key76869", b76869.toString()); // put in a collection
		String c76869 = (String)map76869.get("key76869"); // get it back out
		String d76869 = c76869.substring(0,c76869.length()-1); // extract most of it
		String e76869 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76869.getBytes() ) )); // B64 encode and decode it
		String f76869 = e76869.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76869 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76869); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
