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