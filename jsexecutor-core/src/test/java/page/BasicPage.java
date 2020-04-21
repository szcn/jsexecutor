package page;

import annotation.ExecBy;
import manager.BuilderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicPage
{

    public BasicPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        new BuilderManager(this);
    }

    @FindBy(css = ".login-text>a")
    public WebElement signup;

    @ExecBy(js = "a")
    public String fillForm;
}
