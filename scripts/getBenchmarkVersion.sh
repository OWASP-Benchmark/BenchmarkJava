#!/usr/bin/env sh

mvn org.apache.maven.plugins:maven-help-plugin:evaluate -Dexpression=project.version | grep -v '[INFO]'

