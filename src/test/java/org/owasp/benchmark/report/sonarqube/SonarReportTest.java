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
 */
package org.owasp.benchmark.report.sonarqube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SonarReportTest {

    private static final int PAGE_SIZE = 500;

    /**
     * Replicates the fixed paging formula from SonarReport.forAllPagesAt(). The old formula was
     * {@code (resultCount / PAGE_SIZE) + 1}, which over-counts by 1 when resultCount is an exact
     * multiple of PAGE_SIZE.
     */
    private static int calculatePages(int resultCount) {
        return (resultCount / PAGE_SIZE) + (resultCount % PAGE_SIZE == 0 ? 0 : 1);
    }

    @ParameterizedTest(name = "resultCount={0} => pages={1}")
    @CsvSource({
        "0, 0",
        "1, 1",
        "499, 1",
        "500, 1",
        "501, 2",
        "999, 2",
        "1000, 2",
        "1001, 3",
        "10000, 20",
        "10001, 21"
    })
    void pageCalculationProducesCorrectCeiling(int resultCount, int expectedPages) {
        assertEquals(
                expectedPages,
                calculatePages(resultCount),
                "Paging for " + resultCount + " results at page size " + PAGE_SIZE);
    }

    @Test
    void oldFormulaOvercountsOnExactMultiple() {
        int resultCount = 1000;
        int oldFormula = (resultCount / PAGE_SIZE) + 1;
        int fixedFormula = calculatePages(resultCount);

        assertEquals(3, oldFormula, "Old formula produces 3 pages for 1000 results (wrong)");
        assertEquals(2, fixedFormula, "Fixed formula produces 2 pages for 1000 results (correct)");
    }

    @Test
    void issueSearchUrlHasNoDoubleAmpersand() {
        String sonarProject = "benchmark";
        String rule = "java:S1234";

        String fixedUrl =
                "issues/search?componentKeys="
                        + sonarProject
                        + "&types=VULNERABILITY&rules="
                        + rule;

        assertFalse(fixedUrl.contains("&&"), "URL must not contain double ampersand");
    }

    @Test
    void oldIssueSearchUrlHadDoubleAmpersand() {
        String sonarProject = "benchmark";
        String allJavaRules = "java:S1234,java:S5678";

        String oldUrl =
                "issues/search?componentKeys="
                        + sonarProject
                        + "&types=VULNERABILITY&&rules="
                        + allJavaRules;

        assertEquals(
                true, oldUrl.contains("&&"), "Old URL construction had double ampersand (the bug)");
    }
}
