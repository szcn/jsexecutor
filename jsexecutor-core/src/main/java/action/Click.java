package action;


import annotation.ExecBy;

public class Click
{
    public Click()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "var el = document.getElementById(" + JSConstants.Objects.FIRST + "); const rect = el[" + JSConstants.Objects.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + JSConstants.Objects.SECOND + "].click();}")
    public String idAll;

    @ExecBy(js = "var el = document.getElementsByClassName(" + JSConstants.Objects.FIRST + "); const rect = el[" + JSConstants.Objects.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + JSConstants.Objects.SECOND + "].click();}")
    public String classNameAll;

    @ExecBy(js = "var el = document.getElementsByName(" + JSConstants.Objects.FIRST + "); const rect = el[" + JSConstants.Objects.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + JSConstants.Objects.SECOND + "].click();}")
    public String nameAll;

    @ExecBy(js = "var el = document.querySelector(\"*[href=" + JSConstants.Objects.FIRST + "]\"); const rect = el[" + JSConstants.Objects.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + JSConstants.Objects.SECOND + "].click();}")
    public String linkTextAll;

    @ExecBy(js = "var el = document.getElementsByTagName(" + JSConstants.Objects.FIRST + "); const rect = el[" + JSConstants.Objects.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + JSConstants.Objects.SECOND + "].click();}")
    public String tagNameAll;

    @ExecBy(js = "var el = document.querySelectorAll(" + JSConstants.Objects.FIRST + "); const rect = el[" + JSConstants.Objects.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + JSConstants.Objects.SECOND + "].click();}")
    public String cssAll;

    //TODO array dönmeye bilir. (singleNodeValue)
    @ExecBy(js = "var el = document.evaluate(" + JSConstants.Objects.FIRST + ", document, null,XPathResult.ANY_TYPE, null); var item = el.iterateNext(" + JSConstants.Objects.SECOND + "); const rect = item.getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){item.click();}")
    public String xpathAll;

    @ExecBy(js = "var el = " + JSConstants.Objects.FIRST + "; const rect = el.getBoundingClientRect(); \n" +
            "const windowHeight = (window.innerHeight || document.documentElement.clientHeight);\n" +
            "const windowWidth = (window.innerWidth || document.documentElement.clientWidth);\n" +
            "const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0);\n" +
            "const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0);\n" +
            "if (vertInView & horInView) \n" +
            "{\n" +
            "el.click();\n" +
            "}")
    public String isVisibleClick;

    @ExecBy(js = "document.getElementById(" + JSConstants.Objects.FIRST + ").click();")
    public String id;

    @ExecBy(js = "document.getElementsByClassName(" + JSConstants.Objects.FIRST + ").click();")
    public String className;

    @ExecBy(js = "document.getElementsByName(" + JSConstants.Objects.FIRST + ").click();")
    public String name;

    @ExecBy(js = "document.querySelector(\"*[href=" + JSConstants.Objects.FIRST + "]\").click();")
    public String linkText;

    @ExecBy(js = "document.getElementsByTagName(" + JSConstants.Objects.FIRST + ").click();")
    public String tagName;

    @ExecBy(js = "document.querySelectorAll(" + JSConstants.Objects.FIRST + ").click();")
    public String css;

    @ExecBy(js = "var el = document.evaluate(" + JSConstants.Objects.FIRST + ", document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; el.click();")
    public String xpath;

    @ExecBy(js = "for(var i=0; i < 2; i++) {" + JSConstants.Objects.FIRST + ".click();}")
    public String doubleClick;
}
