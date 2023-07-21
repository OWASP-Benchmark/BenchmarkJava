package org.owasp.benchmark.testcode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.codecs.Base64;

@WebServlet(value = "/deserialization-00/BenchmarkTest02778")
public class BenchmarkTest02778 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie("BenchmarkTest02778", "rO0ABXQAC2hlbGxvIHdvcmxk");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/deserialization-00/BenchmarkTest02778.html");
        rd.include(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        javax.servlet.http.Cookie[] theCookies = request.getCookies();
        String param = "noCookieValueSupplied";
        if (theCookies != null) {
            for (javax.servlet.http.Cookie theCookie : theCookies) {
                if (theCookie.getName().equals("BenchmarkTest02778")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        char[] guessLetters = {'A', 'B', 'C'};
        Random random = new Random();
        char guessChar = guessLetters[random.nextInt(guessLetters.length)];
        ObjectInputStream bar = doSomething(param, guessChar);

        try {
            Object result = bar.readObject();
            bar.close();
            org.owasp.benchmark.helpers.DeserializationHelper.outputDeserializationResults(
                    result, response);

        } catch (ClassNotFoundException e) {
            response.getWriter().println("The entered class was not found.");
        } catch (IOException e) {
            response.getWriter().println("ReadObject Error. / Invalid stream input");
        } catch (NullPointerException e) {
            response.getWriter().println("It is also safe! / Stream is null.");
        } catch (RuntimeException e) {
            response.getWriter().println("Looks like you made it.");
        }
    }

    private static ObjectInputStream doSomething(String param, char guessChar) throws IOException {

        byte[] serializedObject = Base64.decode(param);
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
        String guess = "ABC";
        char switchTarget = guessChar;

        // Simple case statement that assigns param to bar on conditions 'A', 'C', or 'D'
        switch (switchTarget) {
            case 'A':
                ObjectInputStream bis = new ObjectInputStream(bais);
                return bis;
            case 'B':
                break;
            case 'C':
            case 'D':
                ObjectInputStream bis2 = new ObjectInputStream(bais);
                return bis2;
            default:
                break;
        }
        return null;
    }
}
