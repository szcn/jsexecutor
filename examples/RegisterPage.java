public class RegisterPage
{

    public RegisterPage(WebDriver driver)
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

    @Exec(js = "document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();")
    public String registerForm;

    @Exec(jquery = "$('#agreement > label').click()")
    public String agreement;
}