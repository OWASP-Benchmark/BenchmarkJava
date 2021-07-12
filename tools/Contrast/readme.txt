DISCLAIMER: OWASP does not endorse any commercial tools, including this one. Benchmark support for this tool is simply for user convenience and should not be considered an endorsement of this tool.

Contrast is a commercial product, so you need to provide your Contrast credentials in the contrast.yaml file in order to run it. You can use your enterprise Contrast account or sign up for the free Contrast Community Edition (CE) at https://www.contrastsecurity.com/contrast-community-edition.

To run Benchmark with Contrast, you can use the runBenchmark_wContrast.sh script
  1. This script will download the latest Contrast agent
  2. It will start the Benchmark application server with the Contrast agent as configured by contrast.yaml
  3. It will then pause, waiting for input from the web crawler (see next step)
  4. In a separate shell, you need to run the runCrawler.sh script from the Benchmark root directory
  5. When the crawler finishes (after about a minute) *you* hit CTRL+C in the runBenchmark_wContrast window to stop the server
  6. The Contrast script will then copy the Contrast vulnerability results to the Benchmark /results directory
  7. Run createScorecards.sh in the Benchmark root directory to create a detailed scorecard in /scorecard that includes these Contrast results

See the Tool Scanning Tips page at OWASP (https://owasp.org/www-project-benchmark/#div-scanning_tips) for the latest instructions on how to scan the Benchmark with any vulnerability detection tool, including Contrast.

