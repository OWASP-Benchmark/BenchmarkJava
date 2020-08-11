#!/bin/sh

chmod 755 src/main/resources/insecureCmd.sh

case "$1" in
-q|--quiet) quiet="-D-Dorg.owasp.esapi.logSpecial.discard=true"; shift  ;;
*)          quiet=""    ;;
esac
mvn ${quiet} clean package cargo:run -Pdeploy
