import executor.JavaScriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BasicPage;

public class BasicTest
{
    WebDriver driver;
    JavaScriptExecutor jsExecutor;
    BasicPage basicPage;

    @BeforeEach
    public void before(){

        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
        driver = new ChromeDriver();
        jsExecutor = new JavaScriptExecutor(driver);
        basicPage = new BasicPage(driver);

    }

    @Test
    public void basicTest(){

        jsExecutor
                .goToUrl("https://www.sahibinden.com/")
                .click(basicPage.signup)
                .executeScript(basicPage.fillForm);

    }

    @AfterEach
    public void after(){

        driver.close();

    }

}
