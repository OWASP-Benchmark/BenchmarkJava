/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ldapi-00/BenchmarkTest00367")
public class BenchmarkTest00367 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00367");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a12849 = param; //assign
		StringBuilder b12849 = new StringBuilder(a12849);  // stick in stringbuilder
		b12849.append(" SafeStuff"); // append some safe content
		b12849.replace(b12849.length()-"Chars".length(),b12849.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12849 = new java.util.HashMap<String,Object>();
		map12849.put("key12849", b12849.toString()); // put in a collection
		String c12849 = (String)map12849.get("key12849"); // get it back out
		String d12849 = c12849.substring(0,c12849.length()-1); // extract most of it
		String e12849 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d12849.getBytes() ) )); // B64 encode and decode it
		String f12849 = e12849.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g12849 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g12849); // reflection
		
		
	org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
	try {
		response.setContentType("text/html;charset=UTF-8");
		String base = "ou=users,ou=system";
		javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
		sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
		String filter = "(&(objectclass=person))(|(uid="+bar+")(street={0}))";
		Object[] filters = new Object[]{"The streetz 4 Ms bar"};

		javax.naming.directory.DirContext ctx = ads.getDirContext();
		javax.naming.directory.InitialDirContext idc = (javax.naming.directory.InitialDirContext) ctx;
		boolean found = false;
		javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results = 
				idc.search(base, filter,filters, sc);
		while (results.hasMore()) {
			javax.naming.directory.SearchResult sr = (javax.naming.directory.SearchResult) results.next();
			javax.naming.directory.Attributes attrs = sr.getAttributes();

			javax.naming.directory.Attribute attr = attrs.get("uid");
			javax.naming.directory.Attribute attr2 = attrs.get("street");
			if (attr != null){
				response.getWriter().println(
					"LDAP query results:<br>"
					+ "Record found with name " + attr.get() + "<br>"
					+ "Address: " + attr2.get()+ "<br>"
				);
				// System.out.println("record found " + attr.get());
				found = true;
			}
		}
		if (!found) {
			response.getWriter().println(
				"LDAP query results: nothing found for query: " + org.owasp.esapi.ESAPI.encoder().encodeForHTML(filter)
			);
		}
	} catch (javax.naming.NamingException e) {
		throw new ServletException(e);
	} finally {
    		try {
    			ads.closeDirContext();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	}
	
}
