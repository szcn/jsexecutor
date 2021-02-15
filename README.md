[Javascript Executor Framework](http://jsexecutor.com)
==============
[![Apache License, Version 2.0, January 2004](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/com.jsexecutor/jsexecutor-core.svg?label=Maven%20Central)](https://search.maven.org/artifact/com.jsexecutor/jsexecutor-core/1.0.8/jar)
[![Latest release](https://img.shields.io/github/release/szcn/jsexecutor.svg)](https://github.com/szcn/jsexecutor/releases/latest)
[![Build Status](https://travis-ci.com/szcn/jsexecutor.svg?branch=master)](https://travis-ci.com/szcn/jsexecutor)

JavascriptExecutor is an open-source tool for testing web and responsive functionality. It is also a functional testing framework.

# For Java Projects
 - It enables to write and execute your scenarios and helper methods in js file.
 - It enables to model your scripts in your Java classes. (PSM)

For more information visit http://jsexecutor.com.

# Sample Usage

Please refer to [examples](https://github.com/szcn/jsexecutor/tree/master/examples).

<!-- For more examples please refer to [Javascript Executor Examples Project](http://jsexecutor.com)> -->

# Running Against Chrome Browser

In order to be able to run JavascriptExecutor against the Chrome Browser, you need to download the [ChromDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads).

# Building

## Prerequisites

- Java 1.8+

- [Maven 3.3](http://maven.apache.org/download.cgi) or later

## Maven

Add the following dependency in your Pom.xml file to use JavascriptExecutor with Maven:

```xml
<dependency>
  <groupId>com.jsexecutor</groupId>
  <artifactId>jsexecutor-core</artifactId>
  <version>1.0.8</version>
</dependency>
```

## Gradle Groovy

Add the following to use JavascriptExecutor with Gradle Groovy:


```gradle
implementation 'com.jsexecutor:jsexecutor-core:1.0.8'
```

## Gradle Kotlin

Add the following to use JavascriptExecutor with Gradle Groovy:

```gradle
implementation("com.jsexecutor:jsexecutor-core:1.0.8")
```

All releases are available at [Maven Central Repository](https://search.maven.org/artifact/com.jsexecutor/jsexecutor-core/1.0.5/jar).


# Testing

Project can be tested by the following maven command:

```mvn clean test```.


# Contribution

Contributions are always welcomed!

Please read the [contribution guidelines](CONTRIBUTING.md).


# License

Javascript Executor Framework is licensed under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
