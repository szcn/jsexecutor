package action;

import annotation.ExecBy;

public class TextField
{

    public TextField()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "var textContent = " + JSConstants.Objects.FIRST + ".textContent; \n" +
            "if(textContent !== '') {return textContent}\n" +
            "else {return " + JSConstants.Objects.FIRST + ".value;}")
    public String getText;

}
