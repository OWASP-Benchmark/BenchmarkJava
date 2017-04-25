#!/bin/sh

chmod 755 src/main/resources/insecureCmd.sh
mvn clean package cargo:run -Pdeploy -Drunenv=remote