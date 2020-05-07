package action;

import annotation.Exec;
import constants.Constants;
import manager.BuilderManager;

public class Write
{
    public Write()
    {
        new BuilderManager(this);
    }

    @Exec(js = Constants.Arguments.FIRST + ".value = " + Constants.Arguments.SECOND)
    public String setValue;

    /** **/
    @Exec(func = "setValue", path = "src/main/java/script/write.js")
    public String setValueWithJSF;
}
