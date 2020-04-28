import executor.JavaScriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BasicPage;

import java.io.FileNotFoundException;

public class JsFileTest
{
    private final static String url= "https://secure.sahibinden.com/kayit";
    private final static String path = "/opt/chromedriver";

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
    public void jsFileTest() throws FileNotFoundException
    {
        jsExecutor
                .goToUrl(url)
                .sleep(5000)
                .executeScriptWithinFile("individualForm",basicPage.userFormPath);
    }


    @AfterEach
    public void after(){

        driver.close();

    }
}
