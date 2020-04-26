[Javascript Executor Framework](http://jsexecutor.com)
==============
[![Apache License, Version 2.0, January 2004](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/com.jsexecutor/jsexecutor-core.svg?label=Maven%20Central)](https://search.maven.org/artifact/com.jsexecutor/jsexecutor-core/1.0.5/jar)
[![Latest release](https://img.shields.io/github/release/szcn/jsexecutor.svg)](https://github.com/szcn/jsexecutor/releases/latest)

master: [![Build Status](https://travis-ci.com/szcn/jsexecutor.svg?branch=master)](https://travis-ci.com/szcn/jsexecutor)

JavascriptExecutor is an open-source tool for testing web and responsive functional. It is also a powerfull functional testing framework.

For more information visit http://jsexecutor.com , http://javascriptexecutor.com



How does it work?
------------
###...
Here is a small example of basic syntax.

```java
###Page
    public BasicPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        new BuilderManager(this);
    }

    @FindBy(css = ".register-text >a")
    public WebElement signup;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "surname")
    public WebElement surname;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;


    /** Exec **/

    @ExecBy(js = "document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();")
    public String registerForm;

    @ExecBy(js = "document.querySelector('#agreement > label').click();")
    public String agreement;

###Test

    private WebDriver driver;
    private JavaScriptExecutor jsExecutor;
    private BasicPage basicPage;

    @BeforeEach
    public void before(){

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        jsExecutor = new JavaScriptExecutor(driver);
        basicPage = new BasicPage(driver);

    }

    @Test
    public void basicTest(){

        jsExecutor
                .goToUrl(url)
                .click(basicPage.signup)
                .sleep(5000)
                .setValue(basicPage.name, (String) jsExecutor.randomGenerate(DataType.STRING,5))
                .setValue(basicPage.surname,(String) jsExecutor.randomGenerate(DataType.STRING,5))
                .executeScript(basicPage.registerForm)
                .executeScript(basicPage.agreement);


    }
```

For more information please read [Javascript Executor Documentation](http://jsexecutor.com)

Building 
-----------

you'll need:

Java 1.8+

[Maven 3.3](http://maven.apache.org/download.cgi) or later

To add a dependency on JavascriptExecutor using Maven, use the following:

```xml
<dependency>
  <groupId>com.jsexecutor</groupId>
  <artifactId>jsexecutor-core</artifactId>
  <version>1.0.5</version>
</dependency>
```

```
mvn clean install
```

To add a dependency using Gradle Groovy:

```gradle
implementation 'com.jsexecutor:jsexecutor-core:1.0.5'
```

To add a dependency using Gradle Kotlin:

```gradle
implementation("com.jsexecutor:jsexecutor-core:1.0.5")
```

All releases are available in
[Central Repository](https://search.maven.org/artifact/com.jsexecutor/jsexecutor-core/1.0.5/jar)



Testing
-----------
There are two levels of testing. The first one is just the regular ```mvn clean test```. But as there is a lot of Javascript code - you need [Mocha](http://mochajs.org). The tests are located in folder ```src/test/js/```.


License
------------

Javascript Executor Framework is licensed under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
