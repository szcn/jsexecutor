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