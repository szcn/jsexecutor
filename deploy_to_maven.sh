#!/bin/bash

version=$1
settings=$2
passphrase=$3

sh create_maven_release.sh version settings passphrase

echo "Deploy to mavan."

mvn --settings ~/.m2/"${settings}".xml clean deploy

echo "Deploy finished."