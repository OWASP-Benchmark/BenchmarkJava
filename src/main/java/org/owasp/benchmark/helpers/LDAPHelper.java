/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Juan Gama <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.helpers;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

//import sun.misc.BASE64Encoder;

public class LDAPHelper {
	private static Logger logger = Logger.getLogger(LDAPHelper.class);
	private static Hashtable<String, String> env = new Hashtable<String, String>();
	private static DirContext dctx = null;
	
	public LDAPHelper() {
		try {
			/* This needs to be replaced with a real LDAP */
			env.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
			env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
			env.put(Context.SECURITY_CREDENTIALS, "xxx");
		} catch (Exception e) {
			logger.error(e, e);
		}

	}

	public static InitialDirContext getInitialDirContext(){
		return (InitialDirContext)getInitialDirContext();
	}
	
	public static DirContext getDirContext(){
		if(dctx == null){
			try {
				dctx = new InitialDirContext(env);
			} catch (NamingException e) {
				System.out.println("Problem with LDAP init.");
			}
		}
		return dctx;
	}
	
	public static boolean insert(LDAPPerson person) {
		try {

			DirContext ctx = getDirContext();
			Attributes matchAttrs = new BasicAttributes(true);
			matchAttrs.put(new BasicAttribute("uid", person.getName()));
			matchAttrs.put(new BasicAttribute("cn", person.getName()));
			matchAttrs.put(new BasicAttribute("street", person.getAddress()));
			matchAttrs.put(new BasicAttribute("sn", person.getName()));
			matchAttrs.put(new BasicAttribute("userpassword",
					encryptLdapPassword("SHA", person.getPassword())));
			matchAttrs.put(new BasicAttribute("objectclass", "top"));
			matchAttrs.put(new BasicAttribute("objectclass", "person"));
			matchAttrs.put(new BasicAttribute("objectclass",
					"organizationalPerson"));
			matchAttrs.put(new BasicAttribute("objectclass", "inetorgperson"));
			String name = "uid=" + person.getName() + ",ou=users,ou=system";
			InitialDirContext iniDirContext = (InitialDirContext) ctx;
			iniDirContext.bind(name, ctx, matchAttrs);

			logger.debug("success inserting " + person.getName());
			return true;
		} catch (Exception e) {
			logger.error(e, e);
			return false;
		}
	}

	private static boolean edit(LDAPPerson person) {
		try {

			DirContext ctx = getDirContext();
			ModificationItem[] mods = new ModificationItem[2];
			Attribute mod0 = new BasicAttribute("street", person.getAddress());
			Attribute mod1 = new BasicAttribute("userpassword",
					encryptLdapPassword("SHA", person.getPassword()));
			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
			mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);

			ctx.modifyAttributes("uid=" + person.getName()
					+ ",ou=users,ou=system", mods);

			logger.debug("success editing " + person.getName());
			return true;
		} catch (Exception e) {
			logger.error(e, e);
			return false;
		}
	}

	private static boolean delete(LDAPPerson person) {
		try {

			DirContext ctx = getDirContext();
			ctx.destroySubcontext("uid=" + person.getName()
					+ ",ou=users,ou=system");

			logger.debug("success deleting " + person.getName());
			return true;
		} catch (Exception e) {
			logger.error(e, e);
			return false;
		}
	}

	private static boolean search(LDAPPerson person) {
		try {

			DirContext ctx = getDirContext();
			String base = "ou=users,ou=system";

			SearchControls sc = new SearchControls();
			sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

			String filter = "(&(objectclass=person)(uid=" + person.getName()
					+ "))";

			NamingEnumeration<SearchResult> results = ctx.search(base, filter, sc);

			while (results.hasMore()) {
				SearchResult sr = (SearchResult) results.next();
				Attributes attrs = sr.getAttributes();

				Attribute attr = attrs.get("uid");
				if (attr != null)
					logger.debug("record found " + attr.get());
			}
			ctx.close();

			return true;
		} catch (Exception e) {
			logger.error(e, e);
			return false;
		}
	}

	private static String encryptLdapPassword(String algorithm, String _password) {
		/*
		 * Removed until adding BouncyCastle
		String sEncrypted = _password;
		if ((_password != null) && (_password.length() > 0)) {
			boolean bMD5 = algorithm.equalsIgnoreCase("MD5");
			boolean bSHA = algorithm.equalsIgnoreCase("SHA")
					|| algorithm.equalsIgnoreCase("SHA1")
					|| algorithm.equalsIgnoreCase("SHA-1");
			if (bSHA || bMD5) {
				String sAlgorithm = "MD5";
				if (bSHA) {
					sAlgorithm = "SHA";
				}
				try {
					MessageDigest md = MessageDigest.getInstance(sAlgorithm);
					md.update(_password.getBytes("UTF-8"));
					sEncrypted = "{" + sAlgorithm + "}"
							+ (new BASE64Encoder()).encode(md.digest());
				} catch (Exception e) {
					sEncrypted = null;
					logger.error(e, e);
				}
			}
		}
		return sEncrypted;
		*/
		return _password;
	}
}
