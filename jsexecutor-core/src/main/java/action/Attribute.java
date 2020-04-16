package action;

import annotation.ExecBy;

public class Attribute
{

    public Attribute()
    {
        new JSFieldManager(this);
    }

    /**
     * isAttribute
     **/

    @ExecBy(js = "var value = " + JSConstants.Objects.FIRST + ".getAttribute(" + JSConstants.Objects.SECOND + "); if(value !== null) {return true} else return false;")
    public String isAttributePresent;

    @ExecBy(js = "return " + JSConstants.Objects.FIRST + ".getAttribute(" + JSConstants.Objects.SECOND + ");")
    public String getAttribute;

    @ExecBy(js = JSConstants.Objects.FIRST + ".style.backgroundColor = " + JSConstants.Objects.SECOND + "")
    public String setBackgroundStyle;
}
