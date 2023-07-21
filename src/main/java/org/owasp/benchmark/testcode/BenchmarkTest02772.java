package org.owasp.benchmark.testcode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.codecs.Base64;

@WebServlet(value = "/deserialization-00/BenchmarkTest02772")
public class BenchmarkTest02772 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String base64SerializedObject = "";
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest02772");

        if (headers != null && headers.hasMoreElements()) {
            base64SerializedObject = headers.nextElement(); // just grab first element
        }

        String param = java.net.URLDecoder.decode(base64SerializedObject, "UTF-8");

        ObjectInputStream bar = doSomething(param);

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

    private static ObjectInputStream doSomething(String param) throws IOException {

        String a5236 = param; // assign
        StringBuilder b5236 = new StringBuilder(a5236); // stick in stringbuilder
        b5236.append(" SafeStuff"); // append some safe content
        b5236.replace(
                b5236.length() - "Chars".length(),
                b5236.length(),
                "Chars"); // replace some of the end content
        java.util.HashMap<String, Object> map5236 = new java.util.HashMap<String, Object>();
        map5236.put("key5236", b5236.toString()); // put in a collection
        String c5236 = (String) map5236.get("key5236"); // get it back out
        String d5236 = c5236.substring(0, c5236.length() - 1); // extract most of it
        String e5236 =
                new String(
                        org.apache.commons.codec.binary.Base64.decodeBase64(
                                org.apache.commons.codec.binary.Base64.encodeBase64(
                                        d5236.getBytes()))); // B64 encode and decode it
        String f5236 = e5236.split(" ")[0]; // split it on a space
        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String g5236 = "barbarians_at_the_gate"; // This is static so this whole flow is 'safe'

        String bar = null;
        if (bar != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("safe");
            valuesList.add(param);
            valuesList.add("moresafe");

            valuesList.remove(0); // remove the 1st safe value
            bar = valuesList.get(0); // get the param value
            byte[] serializedObject = Base64.decode(bar);
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedObject);
            ObjectInputStream bis = new ObjectInputStream(bais);

            return bis;
        }

        return null;
    }
}
