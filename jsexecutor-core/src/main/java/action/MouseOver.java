package action;

import constants.Constants.Arguments;
import annotation.Exec;
import manager.BuilderManager;

public class MouseOver
{

    public MouseOver()
    {
        new BuilderManager(this);
    }

    @Exec(jquery = "$(document.getElementById(" + Arguments.FIRST + ")).mouseover()")
    public String id;

    @Exec(jquery = "$(document.getElementsByClassName(" + Arguments.FIRST + ")[0]).mouseover()")
    public String className;

    @Exec(jquery = "$(document.getElementsByName(" + Arguments.FIRST + ")[0]).mouseover()")
    public String name;

    @Exec(jquery = "$(document.getElementsByTagName(" + Arguments.FIRST + ")[0]).mouseover()")
    public String tagName;

    @Exec(jquery = "$(document.querySelector(\"*[href=" + Arguments.FIRST + "]\")).mouseover()")
    public String linkText;

    @Exec(jquery = "$(" + Arguments.FIRST + ").mouseover()")
    public String css;

    @Exec(jquery = "var node = document.evaluate(" + Arguments.FIRST + ", document, null, XPathResult" +
            ".ANY_TYPE, null); $(node.iterateNext()).mouseover()")
    public String xpath;


}
