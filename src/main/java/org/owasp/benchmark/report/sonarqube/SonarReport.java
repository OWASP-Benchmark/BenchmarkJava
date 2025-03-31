package org.owasp.benchmark.report.sonarqube;

import static java.lang.String.join;
import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.FileUtils.writeStringToFile;
import static org.apache.commons.io.IOUtils.readLines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import javax.xml.parsers.DocumentBuilderFactory;
import org.owasp.benchmark.report.sonarqube.dto.SonarQubeResult;

public class SonarReport {
    private static final String SONAR_USER = "admin";
    private static final String SONAR_PASSWORD = "P4ssword!!!!";
    private static final String SONAR_PROJECT = "benchmark";
    public static final String SONAR_HOST = "ubuntu-server";
    public static final String SONAR_PORT = "9876";

    private static final int PAGE_SIZE = 500;

    private static final String sonarAuth =
            Base64.getEncoder().encodeToString((SONAR_USER + ":" + SONAR_PASSWORD).getBytes());

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String allJavaRules = String.join(",", allJavaRules());
        List<String> issues = new ArrayList<>();
        List<String> hotspots = new ArrayList<>();

        forAllPagesAt(
                "issues/search?componentKeys="
                        + SONAR_PROJECT
                        + "&types=VULNERABILITY&&rules="
                        + allJavaRules,
                (result -> issues.addAll(result.issues)));
        forAllPagesAt(
                "hotspots/search?projectKey=" + SONAR_PROJECT,
                (result -> hotspots.addAll(result.hotspots)));

        writeStringToFile(
                new File("results/" + resultFilename() + ".json"),
                formattedJson(issues, hotspots),
                defaultCharset());
    }

    private static String resultFilename() throws Exception {
        return "Benchmark_" + benchmarkVersion() + "-sonarqube-v" + apiCall("server/version");
    }

    private static String benchmarkVersion() throws Exception {
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File("pom.xml"))
                .getElementsByTagName("version")
                .item(0)
                .getTextContent();
    }

    private static Set<String> allJavaRules() throws IOException {
        Set<String> javaRuleIds = new HashSet<>();

        forAllPagesAt(
                "rules/search",
                (result) ->
                        result.rules.stream()
                                .filter(rule -> rule.ruleId.startsWith("java:"))
                                .forEach(rule -> javaRuleIds.add(rule.ruleId)));

        return javaRuleIds;
    }

    private static void forAllPagesAt(String apiPath, Consumer<SonarQubeResult> pageHandlerCallback)
            throws IOException {
        int pages;
        int page = 1;

        do {
            SonarQubeResult result =
                    objectMapper.readValue(
                            apiCall(apiPath + pagingSuffix(page, apiPath)), SonarQubeResult.class);

            pages = (result.paging.resultCount / PAGE_SIZE) + 1;

            pageHandlerCallback.accept(result);

            page++;
        } while ((page - 1) < pages);
    }

    private static String pagingSuffix(int page, String apiPath) {
        return (apiPath.contains("?") ? "&" : "?") + "p=" + page + "&ps=" + PAGE_SIZE;
    }

    private static String apiCall(String apiPath) throws IOException {
        URL url = new URL("http://" + SONAR_HOST + ":" + SONAR_PORT + "/api/" + apiPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Basic " + sonarAuth);

        return join("\n", readLines(connection.getInputStream(), defaultCharset()));
    }

    private static String formattedJson(List<String> issues, List<String> hotspots)
            throws JsonProcessingException {
        String sb =
                "{\"issues\":["
                        + join(",", issues)
                        + "],\"hotspots\":["
                        + join(",", hotspots)
                        + "]}";

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(objectMapper.readValue(sb, Object.class));
    }
}
