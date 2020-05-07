package action;

import constants.Constants.Arguments;
import annotation.Exec;
import manager.BuilderManager;

public class Select
{
    public Select()
    {
        new BuilderManager(this);
    }

    @Exec(js = Arguments.FIRST + ".selectedIndex = " + Arguments.SECOND)
    public String selectByIndex;

    @Exec(js = "const changeEvent = new Event('change', {\n" +
            "        bubbles: true\n" +
            "    });" + Arguments.FIRST + ".value = " + Arguments.SECOND + ";" + Arguments.FIRST + ".dispatchEvent(changeEvent)")
    public String selectByValue;

    @Exec(js = "function getSelectedText(el) {\n" +
            "if (el.selectedIndex == -1) return null;\n" +
            "return el.options[el.selectedIndex].text;}\n" +
            "return getSelectedText(" + Arguments.FIRST + ");")
    public String getSelectedOptionVisibleText;

    @Exec(js = "return " + Arguments.FIRST + ".selectedIndex")
    public String getSelectedOptionIndex;

    @Exec(js = "return " + Arguments.FIRST + ".value")
    public String getSelectedOptionValue;

    @Exec(js = "var options = " + Arguments.FIRST + ".options; var text = []\n" +
            "for (i = 0; i < options.length; i++) {text.push(options[i].text);} return text;")
    public String getOptionsText;

    @Exec(js = "var options = " + Arguments.FIRST + ".options; var value = []\n" +
            "for (i = 0; i < options.length; i++) {value.push(options[i].value);} return value;")
    public String getOptionsValue;
}
