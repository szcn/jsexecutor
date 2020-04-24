[Javascript Executor Library](http://jsexecutor.com)
==============
master: [![Build Status](https://travis-ci.com/szcn/jsexecutor.svg?branch=master)](https://travis-ci.com/szcn/jsexecutor)

Jsexecutor is an open-source tool for testing web and responsive functional. It is also a powerfull functional testing library.

For more information visit http://jsexecutor.com



How does it work?
------------
###...
Here is a small example of basic syntax.

```
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

    @FindBy(xpath = "//input[@id=\"email\"]")
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


Testing
-----------
There are two levels of testing. The first one is just the regular ```mvn clean test```. But as there is a lot of Javascript code - you need [Mocha](http://mochajs.org). The tests are located in folder ```src/test/js/```.


License
------------

Javascript Executor Library is licensed under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
