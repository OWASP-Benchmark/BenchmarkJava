#!/bin/sh

echo
echo "NOTE: This crawler requires Firefox. Please install it if you don’t have it already."
echo "ALSO: This crawler will sometimes stop if Firefox is not the window in focus. Be sure to keep Firefox in the foreground during the entire crawl in order to get the best results."
echo

mvn install -Pcrawler
