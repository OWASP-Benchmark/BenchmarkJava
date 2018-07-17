/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ldapi-00/BenchmarkTest00139")
public class BenchmarkTest00139 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		if (request.getHeader("BenchmarkTest00139") != null) {
			param = request.getHeader("BenchmarkTest00139");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		// Chain a bunch of propagators in sequence
		String a48394 = param; //assign
		StringBuilder b48394 = new StringBuilder(a48394);  // stick in stringbuilder
		b48394.append(" SafeStuff"); // append some safe content
		b48394.replace(b48394.length()-"Chars".length(),b48394.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48394 = new java.util.HashMap<String,Object>();
		map48394.put("key48394", b48394.toString()); // put in a collection
		String c48394 = (String)map48394.get("key48394"); // get it back out
		String d48394 = c48394.substring(0,c48394.length()-1); // extract most of it
		String e48394 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d48394.getBytes() ) )); // B64 encode and decode it
		String f48394 = e48394.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g48394 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g48394); // reflection
		
		
	org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
	try {
		response.setContentType("text/html");
		String base = "ou=users,ou=system";
		javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
		sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
		String filter = "(&(objectclass=person)(uid=" + bar
				+ "))";
		
		javax.naming.directory.DirContext ctx = ads.getDirContext();
		javax.naming.directory.InitialDirContext idc = (javax.naming.directory.InitialDirContext) ctx;
		javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results = 
				idc.search(base, filter, sc);
		
		while (results.hasMore()) {
			javax.naming.directory.SearchResult sr = (javax.naming.directory.SearchResult) results.next();
			javax.naming.directory.Attributes attrs = sr.getAttributes();

			javax.naming.directory.Attribute attr = attrs.get("uid");
			javax.naming.directory.Attribute attr2 = attrs.get("street");
			if (attr != null){
				response.getWriter().println(
"LDAP query results:<br>"
						+ " Record found with name " + attr.get() + "<br>"
								+ "Address: " + attr2.get()+ "<br>"
);
				// System.out.println("record found " + attr.get());
			} else response.getWriter().println(
"LDAP query results: nothing found."
);
		}
	} catch (javax.naming.NamingException e) {
		throw new ServletException(e);
	}finally{
    	try {
    		ads.closeDirContext();
		} catch (Exception e) {
			throw new ServletException(e);
		}
    }
	}
	
}
