package action;

import annotation.ExecBy;

import constants.Constants.Arguments;

public class Attribute
{

    public Attribute()
    {
        new JSFieldManager(this);
    }

    /**
     * isAttribute
     **/

    @ExecBy(js = "var value = " + Arguments.FIRST + ".getAttribute(" + Arguments.SECOND + "); if(value !== null) {return true} else return false;")
    public String isAttributePresent;

    @ExecBy(js = "return " + Arguments.FIRST + ".getAttribute(" + Arguments.SECOND + ");")
    public String getAttribute;

    @ExecBy(js = Arguments.FIRST + ".style.backgroundColor = " + Arguments.SECOND + "")
    public String setBackgroundStyle;
}
