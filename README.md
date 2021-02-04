[Javascript Executor Framework](http://jsexecutor.com)
==============
[![Apache License, Version 2.0, January 2004](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/com.jsexecutor/jsexecutor-core.svg?label=Maven%20Central)](https://search.maven.org/artifact/com.jsexecutor/jsexecutor-core/1.0.8/jar)
[![Latest release](https://img.shields.io/github/release/szcn/jsexecutor.svg)](https://github.com/szcn/jsexecutor/releases/latest)

master: [![Build Status](https://travis-ci.com/szcn/jsexecutor.svg?branch=master)](https://travis-ci.com/szcn/jsexecutor)

JavascriptExecutor is an open-source tool for testing web and responsive functional. It is also a functional testing framework.

For more information visit http://jsexecutor.com , http://javascriptexecutor.com



How does it work?
------------
###...
Here is a small example of basic syntax.

### Page
```java

public class RegisterPage
{

    public RegisterPage(WebDriver driver)
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

    @Exec(js = "document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();")
    public String registerForm;

    @Exec(jquery = "$('#agreement > label').click()")
    public String agreement;
}
```
    
### Dao

```java

public class UserDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDAO()
    {
        new BuilderManager(this);
    }

    @Exec(sql = "SELECT NAME FROM USER WHERE ID = ?")
    private String userNameById;


    public String findUserNameById(Long id) {

        return jdbcTemplate.queryForObject(userNameById, new Object[]{id}, String.class);

    }

}
```

### Test

```java
public class UserTest
{
    private WebDriver driver;
    private JavaScriptExecutor jsExecutor;
    private RegisterPage registerPage;
    private UserDAO userDAO;

    @BeforeEach
    public void before(){

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        jsExecutor = new JavaScriptExecutor(driver);
        registerPage = new RegisterPage(driver);
        userDAO = new UserDAO();

    }

    @Test
    public void userRegisterTest(){

        jsExecutor
                .goToUrl(registerPageUrl)
                .sleep(5)
                .setValue(registerPage.name, jsExecutor.randomGenerate(DataType.STRING,5))
                .setValue(registerPage.surname, jsExecutor.randomGenerate(DataType.STRING,5))
                .executeScript(registerPage.registerForm)
                .executeScript(registerPage.agreement)
                .click(registerPage.signup)
                .assertEqual(userName,userDAO.findUserNameById(userId));

    }
}
```

### JS File : userForm.js

```javascript

var individualForm = function () {

    document.getElementById('name').value = "testname";
    document.getElementById('surname').value = "testsurname";
    document.getElementById('email').value = "test@jsexecutor.com";
    document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();
    document.querySelector('#agreement > label').click();

};

var corporateForm = function () {

    document.getElementById('name').value = "testname";
    document.getElementById('surname').value = "testsurname";
    document.getElementById('email').value = "test@jsexecutor.com";
    document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();
    document.querySelector('#agreement > label').click();

};

```
### File Path

```java

public class RegisterPage
{

    public RegisterPage()
    {
        new BuilderManager(this);
    }
    
    @Exec(func = "individualForm", path = "js/userForm.js")
    public String fillUserForm;
}
```

### Test

```java
public class UserTest
{
    private WebDriver driver;
    private JavaScriptExecutor jsExecutor;
    private RegisterPage registerPage;
    
    @BeforeEach
    public void before(){

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        jsExecutor = new JavaScriptExecutor(driver);
        registerPage = new RegisterPage(driver);

    }

    @Test
    public void userRegisterTest(){

        jsExecutor
                .goToUrl(registerPageUrl)
                .sleep(5)
                .invokeFunction(registerPage.fillUserForm)
                .click(registerPage.signup);

    }
}

```

For more information please read [Javascript Executor Documentation](http://jsexecutor.com)

ChromeDriver
-----------
- for running tests against the Chrome browser;
- download url: [https://sites.google.com/a/chromium.org/chromedriver/downloads](https://sites.google.com/a/chromium.org/chromedriver/downloads).

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
  <version>1.0.8</version>
</dependency>
```

To add a dependency using Gradle Groovy:

```gradle
implementation 'com.jsexecutor:jsexecutor-core:1.0.8'
```

To add a dependency using Gradle Kotlin:

```gradle
implementation("com.jsexecutor:jsexecutor-core:1.0.8")
```

All releases are available in
[Central Repository](https://search.maven.org/artifact/com.jsexecutor/jsexecutor-core/1.0.5/jar)



Testing
-----------
```mvn clean test```.


License
------------

Javascript Executor Framework is licensed under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
