package action;

import annotation.Exec;
import constants.Constants.Arguments;
import manager.BuilderManager;

public class TextField
{

    public TextField()
    {
        new BuilderManager(this);
    }

    @Exec(js = "var textContent = " + Arguments.FIRST + ".textContent; \n" +
            "if(textContent !== '') {return textContent}\n" +
            "else {return " + Arguments.FIRST + ".value;}")
    public String getText;

}
