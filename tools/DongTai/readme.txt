DISCLAIMER: OWASP does not endorse any commercial tools, including this one. Benchmark support for this tool is simply for user convenience and should not be considered an endorsement of this tool.

DongTai is an interactive application security testing(IAST) product that supports the detection of OWASP WEB TOP 10 vulnerabilities, multi-request related vulnerabilities (including logic vulnerabilities, unauthorized access vulnerabilities, etc.), third-party component vulnerabilities, etc.

To run Benchmark with DongTai, you can use the runBenchmark_wDongTai.sh script
  1. This script will download the latest DongTai agent
  2. It will start the Benchmark application server with the DongTai agent
  3. It will then pause, waiting for input from the web crawler (see next step)
  4. In a separate shell, you need to run the runCrawler.sh script from the Benchmark root directory
  5. When the crawler finishes (after about a minute) *you* hit CTRL+C in the runBenchmark_wDongTai window to stop the server
  6. Then open demo.iast.io for result.

See the Tool Scanning Tips page at OWASP (https://owasp.org/www-project-benchmark/#div-scanning_tips) for the latest instructions on how to scan the Benchmark with any vulnerability detection tool, including DongTai.

