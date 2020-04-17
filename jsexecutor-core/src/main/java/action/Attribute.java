package action;

import annotation.ExecBy;

import constants.Constants.Arguments;
import manager.BuilderManager;

public class Attribute
{

    public Attribute()
    {
        new BuilderManager(getClass().getEnclosingClass());
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
