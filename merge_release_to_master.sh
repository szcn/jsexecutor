#!/bin/bash

version=$1
settings=$2
passphrase=$3

#last_version=$(git describe --abbrev=0 --tags)

#echo "Tag $last_tag"

#git checkout ${last_version}

cd jsexecutor-core/ || exit 1

echo "$PWD"

mvn --settings ~/.m2/${settings}.xml clean install -Dgpg.skip

echo "Singing and deploy to maven"

i=1
for jar in jar, pom, javadoc.jar, sources.jar; do

  gpg --passphrase "${passphrase}" --output target/jsexecutor-core-"${version}".$jar.sig --sign target/jsexecutor-core-"${version}".$jar

  echo "Sign : $jar"

done

mvn --settings ~/.m2/"${settings}".xml clean deploy

echo "Deploy finished."
