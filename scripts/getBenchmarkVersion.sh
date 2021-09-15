#!/usr/bin/env sh

# run and ignore output completely to prevent installation logs output on first run
mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version > /dev/null

mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -v '[INFO]'
