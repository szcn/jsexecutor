package action;

import annotation.ExecBy;
import constants.Constants.Arguments;
import manager.BuilderManager;

public class TextField
{

    public TextField()
    {
        new BuilderManager(this);
    }

    @ExecBy(js = "var textContent = " + Arguments.FIRST + ".textContent; \n" +
            "if(textContent !== '') {return textContent}\n" +
            "else {return " + Arguments.FIRST + ".value;}")
    public String getText;

}
