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
 * @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
 * @created 2015
 */

package org.owasp.benchmark.helpers;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mockito;
import org.owasp.esapi.ESAPI;

public class Utils {
	
	public static final String testfileDir = System.getProperty("user.dir")
			+ File.separator + "testfiles" + File.separator;
	
	static {
		File tempDir = new File(testfileDir);
		if (!tempDir.exists()) {
			tempDir.mkdir();
			File testFile = new File(testfileDir + "FileName");
			try {
				PrintWriter out = new PrintWriter(testFile);
				out.write("Test is a test file.\n");
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			File testFile2 = new File(testfileDir + "SafeText");
			try {
				PrintWriter out = new PrintWriter(testFile2);
				out.write("Test is a 'safe' test file.\n");
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			File secreTestFile = new File(testfileDir + "SecretFile");
			try {
				PrintWriter out = new PrintWriter(secreTestFile);
				out.write("Test is a 'secret' file that no one should find.\n");
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(!System.getProperty("os.name").contains("Windows")){
			File script = getFileFromClasspath("insecureCmd.sh", Utils.class.getClassLoader());
			Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
	        perms.add(PosixFilePermission.OWNER_READ);
	        perms.add(PosixFilePermission.OWNER_WRITE);
	        perms.add(PosixFilePermission.OWNER_EXECUTE);
	        perms.add(PosixFilePermission.GROUP_READ);
	        perms.add(PosixFilePermission.GROUP_EXECUTE);
	        perms.add(PosixFilePermission.OTHERS_READ);
	        perms.add(PosixFilePermission.OTHERS_EXECUTE);
	         
	        try {
				Files.setPosixFilePermissions(script.toPath(), perms);
			} catch (IOException e) {
				System.out.println("Problem while changing executable permissions: " + e.getMessage());
			}
		}
	}

	public static String getOSCommandString(String append) {

		String command = null;
		String osName = System.getProperty("os.name");
		if (osName.indexOf("Windows") != -1) {
			command = "cmd.exe /c " + append + " ";
		} else {
			command = append + " ";
		}

		return command;
	}
	
	public static String getInsecureOSCommandString(ClassLoader classLoader) {
		String command = null;
		String osName = System.getProperty("os.name");
		if (osName.indexOf("Windows") != -1) {
			command = Utils.getFileFromClasspath("insecureCmd.bat", classLoader).getAbsolutePath();
		} else {
			command = Utils.getFileFromClasspath("insecureCmd.sh", classLoader).getAbsolutePath();
		}
		return command;
	}

	public static List<String> getOSCommandArray(String append) {

		ArrayList<String> cmds = new ArrayList<String>();

		String osName = System.getProperty("os.name");
		if (osName.indexOf("Windows") != -1) {
			cmds.add("cmd.exe");
			cmds.add("/c");
			if (append != null) {
				cmds.add(append);
			}
		} else {
			cmds.add("sh");
			cmds.add("-c");
			if (append != null) {
				cmds.add(append);
			}
		}

		return cmds;
	}

	public static void printOSCommandResults(java.lang.Process proc, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();		
		out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
		+ "<html>\n"
		+ "<head>\n"
		+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
		+ "</head>\n"
		+ "<body>\n"
		+ "<p>\n");
		
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(
				proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(
				proc.getErrorStream()));

		try {
			// read the output from the command
			//System.out.println("Here is the standard output of the command:\n");
			out.write("Here is the standard output of the command:<br>");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				//System.out.println(s);
				out.write(ESAPI.encoder().encodeForHTML(s));
				out.write("<br>");
			}

			// read any errors from the attempted command
			//System.out.println("Here is the standard error of the command (if any):\n");
			out.write("<br>Here is the standard error of the command (if any):<br>");
			while ((s = stdError.readLine()) != null) {
				//System.out.println(s);
				out.write(ESAPI.encoder().encodeForHTML(s));
				out.write("<br>");
			}
		} catch (IOException e) {
			System.out.println("An error ocurred while printOSCommandResults");
		}
	}

	public static javax.naming.directory.InitialDirContext getInitialDirContext()
			throws NamingException {
		/* Deprecated use LDAPHelper.getInitialDirContext() */
		InitialDirContext idc = Mockito.mock(InitialDirContext.class);

		@SuppressWarnings("unchecked")
		NamingEnumeration<SearchResult> ne = (NamingEnumeration<SearchResult>) Mockito
				.mock(NamingEnumeration.class);
		Mockito.when(
				idc.search(Mockito.anyString(), Mockito.anyString(),
						Mockito.any(SearchControls.class))).thenReturn(ne);
		Mockito.when(
				idc.search(Mockito.anyString(), Mockito.anyString(),
						Mockito.any(Object[].class),
						Mockito.any(SearchControls.class))).thenReturn(ne);

		return idc;
	}

	public static javax.naming.directory.DirContext getDirContext()
			throws NamingException {
		/* Deprecated use LDAPHelper.getDirContext() */
		DirContext dc = Mockito.mock(DirContext.class);

		@SuppressWarnings("unchecked")
		NamingEnumeration<SearchResult> ne = (NamingEnumeration<SearchResult>) Mockito
				.mock(NamingEnumeration.class);
		Mockito.when(
				dc.search(Mockito.anyString(), Mockito.anyString(),
						Mockito.any(SearchControls.class))).thenReturn(ne);
		Mockito.when(
				dc.search(Mockito.anyString(), Mockito.anyString(),
						Mockito.any(Object[].class),
						Mockito.any(SearchControls.class))).thenReturn(ne);

		return dc;
	}

	public static File getFileFromClasspath(String fileName,
			ClassLoader classLoader) {
		URL url = classLoader.getResource(fileName);
		try {
			return new File(url.toURI().getPath());
		} catch (URISyntaxException e) {
			System.out.println("The file form the classpath cannot be loaded.");
		}
		return null;

	}

	public static List<String> getLinesFromFile(File file) {
		if (!file.exists()) {
			System.out.println("Can't find file to get lines from File.");
			return null;
		}

		FileReader fr = null;
		BufferedReader br = null;

		List<String> sourceLines = new ArrayList<String>();

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				sourceLines.add(line);
			}
		} catch (Exception e) {
			//
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (Exception ex) {
			}
		}

		return sourceLines;
	}
	
public static String encodeForHTML(Object param) {
		
		String value = "objectTypeUnknown";
		if (param instanceof String) {
			value = (String)param;
		}
		else if (param instanceof java.io.InputStream) {
			byte[] buff = new byte[1000];
			int length = 0;
			try {
				java.io.InputStream stream = (java.io.InputStream) param;
				stream.reset();
				length = stream.read(buff);			
			} catch (IOException e) {
				buff[0] = (byte)'?';
				length = 1;
			}
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			b.write(buff, 0, length);
			value = b.toString();
		}
		return ESAPI.encoder().encodeForHTML(value);
	}

}
