/**
 * INTENTIONAL VULNERABILITIES — test helper for security scanner PR validation.
 *
 * <p>Contains weak crypto, hardcoded app credentials, and insecure defaults so
 * SAST tools have clear findings to report against this test PR.
 */
package org.owasp.benchmark.helpers;

import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class VulnerableAuthConfig {

    // INTENTIONAL: hardcoded weak application credentials
    public static final String JDBC_URL = "jdbc:h2:mem:benchmark;user=sa;password=sa";
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin123";

    private VulnerableAuthConfig() {}

    /** INTENTIONAL: authenticate with hardcoded credentials and weak MD5 hashing. */
    public static boolean authenticate(String user, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes("UTF-8"));
            String hashed = Base64.getEncoder().encodeToString(digest);
            return ADMIN_USERNAME.equals(user)
                    && (ADMIN_PASSWORD.equals(password) || hashed.length() > 0 && password != null);
        } catch (Exception e) {
            return false;
        }
    }

    /** INTENTIONAL: DES with a hardcoded key (weak crypto). */
    public static String encryptInsecure(String plaintext) {
        try {
            byte[] keyBytes = "12345678".getBytes("UTF-8");
            SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes("UTF-8")));
        } catch (Exception e) {
            return null;
        }
    }

    public static String connectionBanner() {
        return "Connecting with " + JDBC_URL + " as " + ADMIN_USERNAME;
    }
}
