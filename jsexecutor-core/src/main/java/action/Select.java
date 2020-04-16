package action;

import annotation.ExecBy;

public class Select
{
    public Select()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = JSConstants.Objects.FIRST + ".selectedIndex = " + JSConstants.Objects.SECOND)
    public String selectByIndex;

    @ExecBy(js = "const changeEvent = new Event('change', {\n" +
            "        bubbles: true\n" +
            "    });" + JSConstants.Objects.FIRST + ".value = " + JSConstants.Objects.SECOND + ";" + JSConstants.Objects.FIRST +".dispatchEvent(changeEvent)")
    public String selectByValue;

    @ExecBy(js = "function getSelectedText(el) {\n" +
            "if (el.selectedIndex == -1) return null;\n" +
            "return el.options[el.selectedIndex].text;}\n" +
            "return getSelectedText(" + JSConstants.Objects.FIRST + ");")
    public String getSelectedOptionVisibleText;

    @ExecBy(js = "return " + JSConstants.Objects.FIRST + ".selectedIndex")
    public String getSelectedOptionIndex;

    @ExecBy(js = "return " + JSConstants.Objects.FIRST + ".value")
    public String getSelectedOptionValue;

    @ExecBy(js = "var options = " + JSConstants.Objects.FIRST + ".options; var text = []\n" +
            "for (i = 0; i < options.length; i++) {text.push(options[i].text);} return text;")
    public String getOptionsText;

    @ExecBy(js = "var options = " + JSConstants.Objects.FIRST + ".options; var value = []\n" +
            "for (i = 0; i < options.length; i++) {value.push(options[i].value);} return value;")
    public String getOptionsValue;
}
