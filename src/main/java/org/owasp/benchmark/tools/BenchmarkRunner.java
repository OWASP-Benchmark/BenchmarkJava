package org.owasp.benchmark.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        System.out.println( "OWASP Benchmark Runner uses the Selenium FirefoxDriver and requires Firefox to be installed.");
        final AtomicInteger nextTest = new AtomicInteger(1);
        long start = System.currentTimeMillis();
        
        int tests = 2740;
        if ( args.length > 0 ) {
            tests = Integer.parseInt( args[0] );
        }
        
        int threads = 1;
        if ( args.length > 1 ) {
            threads = Integer.parseInt( args[1] );
        }

        final int testCount = tests;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for ( int i = 0; i< threads; i++ ) {
            Runnable worker = new Runnable() {
                public void run() {
                    visitTestCases(nextTest, testCount);
                }
            };
            System.out.println("Starting browser " + i );
            executor.execute( worker );
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        long stop = System.currentTimeMillis();
        double elapsed = (stop-start)/(1000*60);
        System.out.println( "Elapsed time: " + elapsed + " minutes" );
    }

    public static void visitTestCases( AtomicInteger nextTest, int tests ) {
        String baseUrl = "https://localhost:8443/benchmark/BenchmarkTest";
        FirefoxDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while( nextTest.get() <= tests ) {
            String test = "000000" + nextTest.getAndIncrement();
            test = test.substring(test.length() - 5);

            try {
                String url = baseUrl + test + ".html";
                System.out.println("URL: " + url);
                driver.get(url);
                
                // get URL, find all buttons, and click them
                for ( WebElement we : driver.findElements(By.tagName("form"))) {
                    we.submit();
                }

                // reload page, and if there's a javascript button, click that
                driver.get(url);
                Thread.sleep(500);
                String jQuerySelector = "#login-btn";
                js.executeScript("$(\"" + jQuerySelector + "\").click();");
                Thread.sleep(500);
            } catch (Exception e) {
                // This is expected since many pages do not have the jquery button
                // System.err.println("  -> ERROR: " + e.getMessage());
            }
        }

        driver.quit();
    }
}
