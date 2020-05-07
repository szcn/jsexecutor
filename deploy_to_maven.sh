#!/bin/bash

version=$1
settings=$2
passphrase=$3

sh create_maven_release.sh "$version" "$settings" "$passphrase"

echo "Deploy to mavan."

cd jsexecutor-core/ || exit 1

mvn --settings ~/.m2/"${settings}".xml clean deploy

echo "Deploy finished."