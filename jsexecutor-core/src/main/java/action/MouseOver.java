package action;


import annotation.ExecBy;

public class MouseOver
{

    public MouseOver()
    {
        new JSFieldManager(this);
    }

    @ExecBy(jquery = "$(document.getElementById(" + JSConstants.Objects.FIRST + ")).mouseover()")
    public String id;

    @ExecBy(jquery = "$(document.getElementsByClassName(" + JSConstants.Objects.FIRST + ")[0]).mouseover()")
    public String className;

    @ExecBy(jquery = "$(document.getElementsByName(" + JSConstants.Objects.FIRST + ")[0]).mouseover()")
    public String name;

    @ExecBy(jquery = "$(document.getElementsByTagName(" + JSConstants.Objects.FIRST + ")[0]).mouseover()")
    public String tagName;

    @ExecBy(jquery = "$(document.querySelector(\"*[href=" + JSConstants.Objects.FIRST + "]\")).mouseover()")
    public String linkText;

    @ExecBy(jquery = "$(" + JSConstants.Objects.FIRST + ").mouseover()")
    public String css;

    @ExecBy(jquery = "var node = document.evaluate(" + JSConstants.Objects.FIRST + ", document, null, XPathResult" +
            ".ANY_TYPE, null); $(node.iterateNext()).mouseover()")
    public String xpath;


}
