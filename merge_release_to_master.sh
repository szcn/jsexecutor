#!/bin/bash

version=$1
settings=$2

last_version=$(git describe --abbrev=0 --tags)

echo "Tag $last_tag"

git checkout ${last_version}

mvn --settings ~/.m2/${settings}.xml clean install -Dgpg.skip


echo "Singing and deploy to maven"

gpg --output target/jsexecutor-core-${version}.jar.sig --sign target/jsexecutor-core-${version}.jar
gpg --output target/jsexecutor-core-${version}.pom.sig --sign target/jsexecutor-core-${version}.pom
gpg --output target/jsexecutor-core-${version}-javadoc.jar.sig --sign target/jsexecutor-core-${version}-javadoc.jar
gpg --output target/jsexecutor-core-${version}-sources.jar.sig --sign target/jsexecutor-core-${version}-sources.jar

mvn --settings ~/.m2/${settings}.xml clean deploy

echo "Deploy finished."
