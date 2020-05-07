#!/bin/bash

version=$1
settings=$2
passphrase=$3

#last_version=$(git describe --abbrev=0 --tags)

#echo "Tag $last_tag"

#git checkout ${last_version}

cd jsexecutor-core/ || exit 1

echo "$PWD"

mvn --settings ~/.m2/"${settings}".xml clean install -Dgpg.skip

echo "Singing"

path=~/.m2/repository/com/jsexecutor/jsexecutor-core/"${version}"/jsexecutor-core-"${version}"

i=1
for jar in .jar .pom -javadoc.jar -sources.jar; do

  echo "path : $path"

  gpg --passphrase "${passphrase}" --output "${path}"$jar.sig --sign "${path}"$jar

  echo "Sign : $jar"

done
