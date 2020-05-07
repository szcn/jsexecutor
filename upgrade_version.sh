#!/bin/bash

old_version=$1
latest_version=$2

sed -i -e "s/$old_version/$latest_version/g" README.md

echo 'version : '"$latest_version"

rm -r README.md-e