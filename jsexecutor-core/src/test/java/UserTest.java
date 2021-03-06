import executor.JavaScriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.UserRegisterPage;
import util.DataType;

public class UserTest
{

    private final static String url= "https://www.sahibinden.com/";
    private final static String path = "/opt/chromedriver";

    private WebDriver driver;
    private JavaScriptExecutor jsExecutor;
    private UserRegisterPage userRegisterPage;

    @BeforeEach
    public void before(){

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        jsExecutor = new JavaScriptExecutor(driver);
        userRegisterPage = new UserRegisterPage(driver);

    }

    @Test
    public void userRegisterTest()
    {

        jsExecutor
                .goToUrl(url)
                .click(userRegisterPage.signup)
                .sleep(5)
                .setValue(userRegisterPage.name, String.valueOf(jsExecutor.randomGenerate(DataType.STRING,5)))
                .setValue(userRegisterPage.surname, String.valueOf(jsExecutor.randomGenerate(DataType.STRING,5)))
                .executeScript(userRegisterPage.registerForm)
                .executeScript(userRegisterPage.agreement)
                .click(userRegisterPage.signup);

    }


    @AfterEach
    public void after(){

        driver.close();

    }
}
