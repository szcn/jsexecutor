import executor.JavaScriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BasicPage;
import util.DataType;

public class BasicTest
{

    private final static String url = "https://www.sahibinden.com/";
    private final static String path = "/opt/chromedriver";

    private WebDriver driver;
    private JavaScriptExecutor jsExecutor;
    private BasicPage basicPage;

    @BeforeEach
    public void before()
    {

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        jsExecutor = new JavaScriptExecutor(driver);
        basicPage = new BasicPage(driver);

    }

    @Test
    public void basicTest()
    {

        jsExecutor
                .goToUrl(url)
                .click(basicPage.signup)
                .sleep(5000)
                .setValue(basicPage.name, (String) jsExecutor.randomGenerate(DataType.STRING, 5))
                .setValue(basicPage.surname, (String) jsExecutor.randomGenerate(DataType.STRING, 5))
                .executeScript(basicPage.registerForm)
                .executeScript(basicPage.agreement);


    }

    @AfterEach
    public void after()
    {

        driver.close();

    }

}
