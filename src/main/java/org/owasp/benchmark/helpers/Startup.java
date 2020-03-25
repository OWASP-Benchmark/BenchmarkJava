/**
 * OWASP Benchmark Project
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Juan Gama
 * @created 2015
 */

package org.owasp.benchmark.helpers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@WebListener
public class Startup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Initializing benchmark");
		try {
			// I believe this is done to force the static initializers in this class to run now
			Class.forName("org.owasp.benchmark.helpers.DatabaseHelper");

			// Have to add BouncyCastle as crypto provider for some of the Crypto test cases
			Security.addProvider(new BouncyCastleProvider());

		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Could not find expected DatabaseHelper class.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: Could not find or add BouncyCastle as crypto provider.");
			e.printStackTrace();
		}

		if (Security.getProvider("BC") == null)
			System.out.println("ERROR: Could not add Bouncy Castle provider for some reason.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
