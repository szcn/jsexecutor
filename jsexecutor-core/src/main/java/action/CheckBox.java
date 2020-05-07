package action;

import annotation.Exec;
import constants.Constants.Arguments;
import manager.BuilderManager;

public class CheckBox
{

    public CheckBox()
    {
        new BuilderManager(this);
    }

    @Exec(js = "var checkboxes = document.querySelectorAll('[type=\"checkbox\"]');\n" +
            "\n" +
            "var result; \n" +
            "\n" +
            "for(var i = 0; i < checkboxes.length; i++) \n" +
            "{\n" +
            " \tif(checkboxes[i].checked === false) \n" +
            "\n" +
            "\t{ \n" +
            "\t return result = false;\n" +
            "\t}\n" +
            "}  \n" +
            "\n" +
            "return result = true;")
    public String checkedControl;

    @Exec(js = "var checkboxes = document.querySelectorAll(\"input[type='checkbox']\"); for(var i = 0; i < " +
            "checkboxes" +
            ".length; i++) {checkboxes[i].checked = true;}")
    public String allClick;

    @Exec(js = "return " + Arguments.FIRST + ".checked;")
    public String checkBoxChecked;

}
