package org.owasp.benchmark.report.sonarqube.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SonarQubeResult {

    public Paging paging;

    public List<Rule> rules;

    @JsonDeserialize(using = KeepAsJsonDeserializer.class)
    public List<String> issues;

    @JsonDeserialize(using = KeepAsJsonDeserializer.class)
    public List<String> hotspots;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Paging {

        @JsonAlias("total")
        public int resultCount;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rule {

        @JsonAlias("key")
        public String ruleId;
    }
}
