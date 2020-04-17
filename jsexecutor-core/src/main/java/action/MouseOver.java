package action;

import constants.Constants.Arguments;
import annotation.ExecBy;
import manager.BuilderManager;

public class MouseOver
{

    public MouseOver()
    {
        new BuilderManager(getClass().getEnclosingClass());
    }

    @ExecBy(jquery = "$(document.getElementById(" + Arguments.FIRST + ")).mouseover()")
    public String id;

    @ExecBy(jquery = "$(document.getElementsByClassName(" + Arguments.FIRST + ")[0]).mouseover()")
    public String className;

    @ExecBy(jquery = "$(document.getElementsByName(" + Arguments.FIRST + ")[0]).mouseover()")
    public String name;

    @ExecBy(jquery = "$(document.getElementsByTagName(" + Arguments.FIRST + ")[0]).mouseover()")
    public String tagName;

    @ExecBy(jquery = "$(document.querySelector(\"*[href=" + Arguments.FIRST + "]\")).mouseover()")
    public String linkText;

    @ExecBy(jquery = "$(" + Arguments.FIRST + ").mouseover()")
    public String css;

    @ExecBy(jquery = "var node = document.evaluate(" + Arguments.FIRST + ", document, null, XPathResult" +
            ".ANY_TYPE, null); $(node.iterateNext()).mouseover()")
    public String xpath;


}
