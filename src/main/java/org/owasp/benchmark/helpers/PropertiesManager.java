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
 * @author Nick Sanidas
 * @created 2015
 */

package org.owasp.benchmark.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
	private String propertiesFileName = null;
	private File file = null;
	private boolean isExternalFile = false;

	public PropertiesManager() {
		propertiesFileName = "benchmark.properties";
		file = Utils.getFileFromClasspath(propertiesFileName, this.getClass().getClassLoader());
	}

	public PropertiesManager(String fileName) {
		propertiesFileName = fileName;
		file = Utils.getFileFromClasspath(propertiesFileName, this.getClass().getClassLoader());
	}

	public PropertiesManager(String path, String fileName) {
		isExternalFile = true;
		propertiesFileName = fileName;
		file = new File(path + File.separator + fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Problem creating new properties file.");
			}
		}
	}

	public void displayProperties() {
		Properties props = new Properties();
		InputStream is = null;
		try {
			is = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			props.load(is);
		} catch (Exception e) {
		}

		System.out.println(props.keySet());
		System.out.println(props.values());
	}

	public String getProperty(String key, String defaultValue) {
		Properties props = new Properties();
		InputStream is = null;
		try {
			if (isExternalFile) {
				is = new FileInputStream(file);
			} else {
				is = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			}
			props.load(is);
		} catch (Exception e) {
		}

		return props.getProperty(key, defaultValue);
	}

	public int getProperty(String key, int defaultValue) {
		Properties props = new Properties();
		InputStream is = null;
		try {
			if (isExternalFile) {
				is = new FileInputStream(file);
			} else {
				is = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			}
			props.load(is);
		} catch (Exception e) {
		}

		return Integer.parseInt(props.getProperty(key, Integer.toString(defaultValue)));
	}

	public void saveProperty(String key, String value) {
		InputStream in = null;
		try {
			if (isExternalFile) {
				in = new FileInputStream(file);
			} else {
				in = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			}
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(file);
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			System.out.println("There was a problem saving a property in the properties file");
		}
	}

	public void removeProperty(String key) {
		InputStream in = null;
		try {
			in = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName);

			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(file);
			props.remove(key);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			System.out.println("There was a problem removing a property from the properties file");
		}

	}

}