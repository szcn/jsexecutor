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
    private final static String url= "https://www.sahibinden.com/";
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
                .click(basicPage.signup)
                .sleep(5000)
                //TODO : bunu jsfile ile var olarak gönder anatasyonun içinde sonra individualForm:path olarak set edilen yerde managerde birleştir sonra scannerda kes
                .executeScriptWithinFile("individualForm",basicPage.userFormPath);


    }


    @AfterEach
    public void after(){

        driver.close();

    }
}
