public class RegisterPage
{

    public RegisterPage()
    {
        new BuilderManager(this);
    }
    
    @Exec(func = "individualForm", path = "js/userForm.js")
    public String fillUserForm;
}