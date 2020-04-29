package page;

import annotation.ExecBy;
import manager.BuilderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegisterPage
{

    public UserRegisterPage(WebDriver driver)
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

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;


    /** Exec **/

    @ExecBy(js = "document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click()")
    public String registerForm;

    @ExecBy(jquery = "$('#agreement > label').click()")
    public String agreement;

    @ExecBy(path = "js/userForm.js", func = "individualForm")
    public String userFormPath;
}
