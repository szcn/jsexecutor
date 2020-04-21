package action;

import constants.Constants.Arguments;
import annotation.ExecBy;
import manager.BuilderManager;

public class Select
{
    public Select()
    {
        new BuilderManager(this);
    }

    @ExecBy(js = Arguments.FIRST + ".selectedIndex = " + Arguments.SECOND)
    public String selectByIndex;

    @ExecBy(js = "const changeEvent = new Event('change', {\n" +
            "        bubbles: true\n" +
            "    });" + Arguments.FIRST + ".value = " + Arguments.SECOND + ";" + Arguments.FIRST + ".dispatchEvent(changeEvent)")
    public String selectByValue;

    @ExecBy(js = "function getSelectedText(el) {\n" +
            "if (el.selectedIndex == -1) return null;\n" +
            "return el.options[el.selectedIndex].text;}\n" +
            "return getSelectedText(" + Arguments.FIRST + ");")
    public String getSelectedOptionVisibleText;

    @ExecBy(js = "return " + Arguments.FIRST + ".selectedIndex")
    public String getSelectedOptionIndex;

    @ExecBy(js = "return " + Arguments.FIRST + ".value")
    public String getSelectedOptionValue;

    @ExecBy(js = "var options = " + Arguments.FIRST + ".options; var text = []\n" +
            "for (i = 0; i < options.length; i++) {text.push(options[i].text);} return text;")
    public String getOptionsText;

    @ExecBy(js = "var options = " + Arguments.FIRST + ".options; var value = []\n" +
            "for (i = 0; i < options.length; i++) {value.push(options[i].value);} return value;")
    public String getOptionsValue;
}
