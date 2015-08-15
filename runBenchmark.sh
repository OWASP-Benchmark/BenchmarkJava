#!/bin/sh

chmod 755 src/main/resources/insecureCmd.sh
mvn clean compile verify cargo:run -Pdeploy