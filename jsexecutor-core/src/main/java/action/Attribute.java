package action;

import annotation.Exec;

import constants.Constants.Arguments;
import manager.BuilderManager;

public class Attribute
{

    public Attribute()
    {
        new BuilderManager(this);
    }

    @Exec(js = "var value = " + Arguments.FIRST + ".getAttribute(" + Arguments.SECOND + "); if(value !== null) {return true} else return false;")
    public String isAttributePresent;

    @Exec(js = "return " + Arguments.FIRST + ".getAttribute(" + Arguments.SECOND + ");")
    public String getAttribute;

    @Exec(js = Arguments.FIRST + ".style.backgroundColor = " + Arguments.SECOND)
    public String setBackgroundStyle;
}
