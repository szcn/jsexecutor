## Javascript Executor Framework


### Page

```markdown
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
```

### Test

```markdown
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
