/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * @author Nick Sanidas
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
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.security.CodeSource;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.TrustSelfSignedStrategy;
import org.apache.hc.core5.ssl.SSLContexts;
import org.owasp.benchmark.service.pojo.XMLMessage;
import org.owasp.esapi.ESAPI;

public class Utils {

    // Properties used by the generated test suite

    public static final String USERDIR = System.getProperty("user.dir") + File.separator;

    // A 'test' directory that target test files are created in so test cases can use them
    public static final String TESTFILES_DIR = USERDIR + "testfiles" + File.separator;

    // This constant is used by one of the sources for Benchmark 1.2, but not in 1.3+.
    // It is used to filter out common headers. Whatever is left is considered the custom header
    // name for header names test cases
    public static final Set<String> commonHeaders =
            new HashSet<>(
                    Arrays.asList(
                            "accept",
                            "accept-encoding",
                            "accept-language",
                            "cache-control",
                            "connection",
                            "content-length",
                            "content-type",
                            "cookie",
                            "host",
                            "origin",
                            "pragma",
                            "referer",
                            "sec-ch-ua",
                            "sec-ch-ua-mobile",
                            "sec-ch-ua-platform",
                            "sec-fetch-dest",
                            "sec-fetch-mode",
                            "sec-fetch-site",
                            "user-agent",
                            "x-requested-with"));

    private static final DocumentBuilderFactory safeDocBuilderFactory =
            DocumentBuilderFactory.newInstance();

    static {
        try {
            // Make DBF safe from XXE by disabling doctype declarations (per OWASP XXE cheat sheet)
            safeDocBuilderFactory.setFeature(
                    "http://apache.org/xml/features/disallow-doctype-decl", true);
        } catch (ParserConfigurationException e) {
            System.out.println(
                    "ERROR: couldn't set http://apache.org/xml/features/disallow-doctype-decl");
            e.printStackTrace();
        }

        File tempDir = new File(TESTFILES_DIR);
        if (!tempDir.exists()) {
            tempDir.mkdir();
            File testFile = new File(TESTFILES_DIR + "FileName");
            try {
                PrintWriter out = new PrintWriter(testFile);
                out.write("Test is a test file.\n");
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            File testFile2 = new File(TESTFILES_DIR + "SafeText");
            try {
                PrintWriter out = new PrintWriter(testFile2);
                out.write("Test is a 'safe' test file.\n");
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            File secreTestFile = new File(TESTFILES_DIR + "SecretFile");
            try {
                PrintWriter out = new PrintWriter(secreTestFile);
                out.write("Test is a 'secret' file that no one should find.\n");
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // The target script is exploded out of the WAR file. When this occurs, the file
        // loses its execute permissions. So this hack adds the required execute permissions back.
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
                System.out.println(
                        "Problem while changing executable permissions: " + e.getMessage());
            }
        }
    }

    public static String getCookie(HttpServletRequest request, String paramName) {
        Cookie[] values = request.getCookies();
        String param = "none";
        if (paramName != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i].getName().equals(paramName)) {
                    param = values[i].getValue();
                    break; // break out of for loop when param found
                }
            }
        }
        return param;
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

    // A method used by the Benchmark JAVA test cases to format OS Command Output
    public static void printOSCommandResults(java.lang.Process proc, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.write(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<p>\n");

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        try {
            // read the output from the command
            // System.out.println("Here is the standard output of the
            // command:\n");
            out.write("Here is the standard output of the command:<br>");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                out.write(ESAPI.encoder().encodeForHTML(s));
                out.write("<br>");
            }

            // read any errors from the attempted command
            // System.out.println("Here is the standard error of the command (if
            // any):\n");
            out.write("<br>Here is the std err of the command (if any):<br>");
            while ((s = stdError.readLine()) != null) {
                out.write(ESAPI.encoder().encodeForHTML(s));
                out.write("<br>");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading OSCommandResults");
            e.printStackTrace();
        }
    }

    // A method used by the Benchmark JAVA test cases to format OS Command Output
    // This version is only used by the Web Services test cases.
    public static void printOSCommandResults(java.lang.Process proc, List<XMLMessage> resp) {

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        try {
            // read the output from the command
            resp.add(new XMLMessage("Here is the standard output of the command:"));
            String s = null;
            StringBuffer out = new StringBuffer();
            StringBuffer outError = new StringBuffer();

            while ((s = stdInput.readLine()) != null) {
                out.append(s).append("\n");
            }
            resp.add(new XMLMessage(out.toString()));
            // read any errors from the attempted command
            resp.add(new XMLMessage("Here is the std err of the command (if any):"));
            while ((s = stdError.readLine()) != null) {
                outError.append(s).append("\n");
            }

            resp.add(new XMLMessage(outError.toString()));
        } catch (IOException e) {
            System.out.println("An error occurred while reading OSCommandResults");
            e.printStackTrace();
        }
    }

    public static File getFileFromClasspath(String fileName, ClassLoader classLoader) {
        URL url = classLoader.getResource(fileName);
        if (url != null) {
            try {
                return new File(url.toURI().getPath());
            } catch (URISyntaxException e) {
                System.out.println(
                        "The file '" + fileName + "' cannot be loaded from the classpath.");
                e.printStackTrace();
            }
        } else System.out.println("The file '" + fileName + "' cannot be found on the classpath.");
        return null;
    }

    public static List<String> getLinesFromFile(File file) {
        if (!file.exists()) {
            try {
                System.out.println("Can't find file to get lines from: " + file.getCanonicalFile());
            } catch (IOException e) {
                System.out.println("Can't find file to get lines from.");
                e.printStackTrace();
            }
            return null;
        }

        List<String> sourceLines = new ArrayList<String>();

        try (FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr); ) {
            String line;
            while ((line = br.readLine()) != null) {
                sourceLines.add(line);
            }
        } catch (Exception e) {
            try {
                System.out.println("Problem reading contents of file: " + file.getCanonicalFile());
            } catch (IOException e2) {
                System.out.println("Problem reading file to get lines from.");
                e2.printStackTrace();
            }
            e.printStackTrace();
        }

        return sourceLines;
    }

    public static List<String> getLinesFromFile(String filename) {
        return getLinesFromFile(new File(filename));
    }

    /**
     * Encodes the supplied parameter using ESAPI's encodeForHTML(). Only supports Strings and
     * InputStreams.
     *
     * @param param - The String or InputStream to encode.
     * @return - HTML Entity encoded version of input, or "objectTypeUnknown" if not a supported
     *     type.
     */
    public static String encodeForHTML(Object param) {

        String value = "objectTypeUnknown";
        if (param instanceof String) {
            value = (String) param;
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

    public static boolean writeLineToFile(Path pathToFileDir, String completeName, String line) {
        boolean result = true;
        PrintStream os = null;
        try {
            Files.createDirectories(pathToFileDir);
            File f = new File(completeName);
            if (!f.exists()) {
                f.createNewFile();
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

    /*
     * A utility method used by the generated Java Cipher test cases.
     */
    private static javax.crypto.Cipher cipher = null;

    public static Cipher getCipher() {
        if (cipher == null) {
            try {
                cipher =
                        javax.crypto.Cipher.getInstance(
                                "RSA/ECB/OAEPWithSHA-512AndMGF1Padding", "SunJCE");
                // Prepare the cipher to encrypt
                java.security.KeyPairGenerator keyGen =
                        java.security.KeyPairGenerator.getInstance("RSA");
                keyGen.initialize(4096);
                java.security.PublicKey publicKey = keyGen.genKeyPair().getPublic();
                cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, publicKey);
            } catch (NoSuchAlgorithmException
                    | NoSuchProviderException
                    | NoSuchPaddingException
                    | InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        return cipher;
    }

    public static SSLConnectionSocketFactory getSSLFactory() throws Exception {
        SSLContext sslcontext =
                SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf =
                new SSLConnectionSocketFactory(
                        sslcontext, new String[] {"TLSv1"}, null, NoopHostnameVerifier.INSTANCE);
        return sslsf;
    }

    /**
     * This method returns information about which library the supplied class came from. This is
     * useful when determining what class a Factory instantiated, for example. Mainly used for XXE
     * verification/debugging.
     *
     * @param The name of the class being passed in.
     * @param The class to print information about.
     * @return A string containing the Component Name, the name of the class, possibly the
     *     implementation vendor, spec version, implementation version, and the library it came from
     *     (or Java Runtime it came from).
     */
    public static String getClassImplementationInfo(String componentName, Class componentClass) {
        CodeSource source = componentClass.getProtectionDomain().getCodeSource();
        Package p = componentClass.getPackage();
        return MessageFormat.format(
                "{0} implementation: {1} ({2}) version {3} ({4}) loaded from: {5}",
                componentName,
                componentClass.getName(),
                p.getImplementationVendor(),
                p.getSpecificationVersion(),
                p.getImplementationVersion(),
                source == null ? "Java_Runtime" : source.getLocation());
    }
}
