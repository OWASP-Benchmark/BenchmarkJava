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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.mockito.Mockito;
import org.owasp.benchmark.service.pojo.StringMessage;
import org.owasp.benchmark.tools.AbstractTestCaseRequest;
import org.owasp.benchmark.tools.ServletTestCaseRequest;
import org.owasp.benchmark.tools.XMLCrawler;
import org.owasp.esapi.ESAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class Utils {

	public static final String testfileDir = System.getProperty("user.dir") + File.separator + "testfiles"
			+ File.separator;

	public static final String failedTCFile = System.getProperty("user.dir") + File.separator + "data" + File.separator
			+ "benchmark-failed-http.xml";

	public static final String BENCHMARK_DATA = System.getProperty("user.dir") + File.separator + "data"
			+ File.separator;

	public static final Set<String> commonHeaders = new HashSet<>(Arrays.asList("host", "user-agent", "accept",
			"accept-language", "accept-encoding", "content-type", "x-requested-with", "referer", "content-length",
			"connection", "pragma", "cache-control", "origin", "cookie"));

	public static final String DATAFOLDER_PATH = System.getProperty("user.dir") + File.separator + "data"
			+ File.separator;

	private static javax.crypto.Cipher cipher = null;

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
		if (!System.getProperty("os.name").contains("Windows")) {
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
		out.write(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
						+ "<html>\n" + "<head>\n"
						+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" + "</head>\n"
						+ "<body>\n" + "<p>\n");

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		try {
			// read the output from the command
			// System.out.println("Here is the standard output of the
			// command:\n");
			out.write("Here is the standard output of the command:<br>");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				// System.out.println(s);
				out.write(ESAPI.encoder().encodeForHTML(s));
				out.write("<br>");
			}

			// read any errors from the attempted command
			// System.out.println("Here is the standard error of the command (if
			// any):\n");
			out.write("<br>Here is the std err of the command (if any):<br>");
			while ((s = stdError.readLine()) != null) {
				// System.out.println(s);
				out.write(ESAPI.encoder().encodeForHTML(s));
				out.write("<br>");
			}
		} catch (IOException e) {
			System.out.println("An error ocurred while printOSCommandResults");
		}
	}

	public static void printOSCommandResults(java.lang.Process proc, List<StringMessage> resp) throws IOException {
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		try {
			// read the output from the command
			resp.add(new StringMessage("Message", "Here is the standard output of the command:<br>"));
			String s = null;
			String out = null;
			String outError = null;
			while ((s = stdInput.readLine()) != null) {
				out = ESAPI.encoder().encodeForHTML(s) + "<br>";
			}
			resp.add(new StringMessage("Message", out));
			// read any errors from the attempted command
			resp.add(new StringMessage("Message", "<br>Here is the std err of the command (if any):<br>"));
			while ((s = stdError.readLine()) != null) {
				outError = ESAPI.encoder().encodeForHTML(s) + "<br>";
			}

			resp.add(new StringMessage("Message", outError));
		} catch (IOException e) {
			System.out.println("An error ocurred while printOSCommandResults");
		}
	}

	public static javax.naming.directory.InitialDirContext getInitialDirContext() throws NamingException {
		/* Deprecated use LDAPHelper.getInitialDirContext() */
		InitialDirContext idc = Mockito.mock(InitialDirContext.class);

		@SuppressWarnings("unchecked")
		NamingEnumeration<SearchResult> ne = (NamingEnumeration<SearchResult>) Mockito.mock(NamingEnumeration.class);
		Mockito.when(idc.search(Mockito.anyString(), Mockito.anyString(), Mockito.any(SearchControls.class)))
				.thenReturn(ne);
		Mockito.when(idc.search(Mockito.anyString(), Mockito.anyString(), Mockito.any(Object[].class),
				Mockito.any(SearchControls.class))).thenReturn(ne);

		return idc;
	}

	public static javax.naming.directory.DirContext getDirContext() throws NamingException {
		/* Deprecated use LDAPHelper.getDirContext() */
		DirContext dc = Mockito.mock(DirContext.class);

		@SuppressWarnings("unchecked")
		NamingEnumeration<SearchResult> ne = (NamingEnumeration<SearchResult>) Mockito.mock(NamingEnumeration.class);
		Mockito.when(dc.search(Mockito.anyString(), Mockito.anyString(), Mockito.any(SearchControls.class)))
				.thenReturn(ne);
		Mockito.when(dc.search(Mockito.anyString(), Mockito.anyString(), Mockito.any(Object[].class),
				Mockito.any(SearchControls.class))).thenReturn(ne);

		return dc;
	}

	public static File getFileFromClasspath(String fileName, ClassLoader classLoader) {
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
		} else if (param instanceof java.io.InputStream) {
			byte[] buff = new byte[1000];
			int length = 0;
			try {
				java.io.InputStream stream = (java.io.InputStream) param;
				stream.reset();
				length = stream.read(buff);
			} catch (IOException e) {
				buff[0] = (byte) '?';
				length = 1;
			}
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			b.write(buff, 0, length);
			value = b.toString();
		}
		return ESAPI.encoder().encodeForHTML(value);
	}

	public static boolean writeTimeFile(Path pathToFileDir, String completeName, List<String> outputLines,
			boolean append) {
		boolean result = true;
		PrintStream os = null;
		try {
			Files.createDirectories(pathToFileDir);
			File f = new File(completeName);
			if (!append) {
				f.delete();
			}
			FileOutputStream fos = new FileOutputStream(f, append);
			os = new PrintStream(fos);

			for (String ol : outputLines) {
				os.println(ol);
			}

		} catch (IOException e1) {
			result = false;
			e1.printStackTrace();
		} finally {
			os.close();
		}

		return result;
	}

	public static boolean writeLineToFile(Path pathToFileDir, String completeName, String line) {
		boolean result = true;
		PrintStream os = null;
		try {
			Files.createDirectories(pathToFileDir);
			File f = new File(completeName);
			if (!f.exists()) {
				// System.out.println("Archivo llamado: " +
				// f.getAbsolutePath());
				f.createNewFile();
				// System.out.println("Archivo no existia se creoooooooooo");
			}
			FileOutputStream fos = new FileOutputStream(f, true);
			os = new PrintStream(fos);
			os.println(line);
		} catch (IOException e1) {
			result = false;
			e1.printStackTrace();
		} finally {
			os.close();
		}

		return result;
	}

	public static boolean deleteFile(String completeName) {
		boolean result = true;
		File f = new File(completeName);
		if (f.exists()) {
			try {
				f.delete();
			} catch (SecurityException e) {
				System.out.println("Can't delete file: " + completeName);
				result = false;
			}
		}
		return result;
	}

	public static List<AbstractTestCaseRequest> parseHttpFile(InputStream http, List<String> failedTestCases)
			throws Exception {
		String URL = "";

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource(http);
		Document doc = docBuilder.parse(is);
		Node root = doc.getDocumentElement();

		DocumentBuilderFactory newCrawlerBF = null;
		DocumentBuilder newCrawlerBuilder = null;
		Document newCrawlerDoc = null;
		Element newCrawkerRootElement = null;
		newCrawlerBF = DocumentBuilderFactory.newInstance();
		Node newNode;

		try {
			newCrawlerBuilder = newCrawlerBF.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Problem init the Crawler XML file");
		}
		newCrawlerDoc = newCrawlerBuilder.newDocument();
		newCrawkerRootElement = newCrawlerDoc.createElement("benchmarkSuite");
		newCrawlerDoc.appendChild(newCrawkerRootElement);

		List<AbstractTestCaseRequest> requests = new ArrayList<AbstractTestCaseRequest>();
		List<Node> tests = XMLCrawler.getNamedChildren("benchmarkTest", root);
		for (Node test : tests) {
			URL = XMLCrawler.getAttributeValue("URL", test).trim();
			if (failedTestCases
					.contains(URL.substring(URL.indexOf("BenchmarkTest"), URL.indexOf("BenchmarkTest") + 18))) {
				requests.add(parseHttpTest(test));
				newNode = test.cloneNode(true);
				newCrawlerDoc.adoptNode(newNode);
				newCrawlerDoc.getDocumentElement().appendChild(newNode);
			} else {
				/* The test case passed */
			}
		}

		File file = new File(failedTCFile);
		if (file.exists()) {
			if (file.delete()) {
				// System.out.println("Crawler file " + fileName + " deleted.");
			}
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(newCrawlerDoc);

			StreamResult result = new StreamResult(failedTCFile);

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);
		} catch (TransformerException e) {
			// System.out.println("Problem closing Crawler XML file: " +
			// fileName);
			e.printStackTrace();
		}

		return requests;
	}

	public static String getCrawlerBenchmarkVersion(InputStream http) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource(http);
		Document doc = docBuilder.parse(is);
		Node root = doc.getDocumentElement();

		return XMLCrawler.getAttributeValue("version", root);
	}

	public static List<AbstractTestCaseRequest> parseHttpFile(InputStream http) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource(http);
		Document doc = docBuilder.parse(is);
		Node root = doc.getDocumentElement();

		List<AbstractTestCaseRequest> requests = new ArrayList<AbstractTestCaseRequest>();
		List<Node> tests = XMLCrawler.getNamedChildren("benchmarkTest", root);
		for (Node test : tests) {
			AbstractTestCaseRequest request = parseHttpTest(test);
			requests.add(request);
		}
		return requests;
	}

	public static AbstractTestCaseRequest parseHttpTest(Node test) throws Exception {
		String tcType = XMLCrawler.getAttributeValue("tcType", test);
		String fullURL = XMLCrawler.getAttributeValue("URL", test);
		String name = "BenchmarkTest" + XMLCrawler.getAttributeValue("tname", test);
		String payload = "";

		List<Node> headers = XMLCrawler.getNamedChildren("header", test);
		List<Node> cookies = XMLCrawler.getNamedChildren("cookie", test);
		List<Node> getParams = XMLCrawler.getNamedChildren("getparam", test);
		List<Node> formParams = XMLCrawler.getNamedChildren("formparam", test);

		switch (tcType) {
		case "SERVLET":
			ServletTestCaseRequest svlTC = new ServletTestCaseRequest(name, fullURL, tcType, headers, cookies,
					getParams, formParams, payload);
			return svlTC;
		}

		return null;
	}

	public static List<String> readCSVFailedTC(String csvFile) {
		String line = "";
		String cvsSplitBy = ",";
		List<String> csv = new ArrayList<String>();
		String[] tempLine;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				tempLine = line.split(cvsSplitBy);
				if (tempLine[5].trim().equalsIgnoreCase("fail")) {
					csv.add(tempLine[0]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csv;
	}

	public static Cipher getCipher() {
		if (cipher == null) {
			try {
				cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
				// Prepare the cipher to encrypt
				java.security.KeyPairGenerator keyGen = java.security.KeyPairGenerator.getInstance("RSA");
				keyGen.initialize(4096);
				java.security.PublicKey publicKey = keyGen.genKeyPair().getPublic();
				cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, publicKey);
			} catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException
					| InvalidKeyException e) {
				e.printStackTrace();
			}
		}
		return cipher;
	}

	public static SSLConnectionSocketFactory getSSLFactory() throws Exception {
		SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				NoopHostnameVerifier.INSTANCE);
		return sslsf;
	}

	public static void printRequestBase(HttpRequestBase request) {
		System.out.println(request.toString());
		for (Header header : request.getAllHeaders()) {
			System.out.println(header.getName() + " : " + header.getValue());
		}
		HttpEntity entity = ((HttpPost) request).getEntity();

		try {
			System.out.println(EntityUtils.toString(entity));
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}

}
