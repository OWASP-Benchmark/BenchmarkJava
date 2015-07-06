package org.owasp.benchmark.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
	
public class PropertiesManager {
	private String propertiesFileName = null;
	private File file = null;

	public PropertiesManager() {
		propertiesFileName = "benchmark.properties";
		file = Utils.getFileFromClasspath(propertiesFileName, this.getClass()
				.getClassLoader());
	}

	public PropertiesManager(String fileName) {
		propertiesFileName = fileName;
		file = Utils.getFileFromClasspath(propertiesFileName, this.getClass()
				.getClassLoader());
	}

	public void displayProperties() {
		Properties props = new Properties();
		InputStream is = null;
		try {
			is = this.getClass().getClassLoader()
					.getResourceAsStream(propertiesFileName);
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
			is = this.getClass().getClassLoader()
					.getResourceAsStream(propertiesFileName);
			props.load(is);
		} catch (Exception e) {
		}

		return props.getProperty(key, defaultValue);
	}

	public void saveProperty(String key, String value) {
		InputStream in = null;
		try {
			in = this.getClass().getClassLoader()
					.getResourceAsStream(propertiesFileName);

			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(file);
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			System.out
					.println("There was a problem saving a property in the properties file");
		}
	}

	public void removeProperty(String key) {
		InputStream in = null;
		try {
			in = this.getClass().getClassLoader()
					.getResourceAsStream(propertiesFileName);

			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(file);
			props.remove(key);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			System.out
					.println("There was a problem removing a property from the properties file");
		}

	}

}