package action;

import constants.Constants.Arguments;
import annotation.ExecBy;

public class Click
{
    public Click()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "var el = document.getElementById(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String idAll;

    @ExecBy(js = "var el = document.getElementsByClassName(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String classNameAll;

    @ExecBy(js = "var el = document.getElementsByName(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String nameAll;

    @ExecBy(js = "var el = document.querySelector(\"*[href=" + Arguments.FIRST + "]\"); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String linkTextAll;

    @ExecBy(js = "var el = document.getElementsByTagName(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String tagNameAll;

    @ExecBy(js = "var el = document.querySelectorAll(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String cssAll;

    //TODO array dönmeye bilir. (singleNodeValue)
    @ExecBy(js = "var el = document.evaluate(" + Arguments.FIRST + ", document, null,XPathResult.ANY_TYPE, null); var item = el.iterateNext(" + Arguments.SECOND + "); const rect = item.getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){item.click();}")
    public String xpathAll;

    @ExecBy(js = "var el = " + Arguments.FIRST + "; const rect = el.getBoundingClientRect(); \n" +
            "const windowHeight = (window.innerHeight || document.documentElement.clientHeight);\n" +
            "const windowWidth = (window.innerWidth || document.documentElement.clientWidth);\n" +
            "const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0);\n" +
            "const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0);\n" +
            "if (vertInView & horInView) \n" +
            "{\n" +
            "el.click();\n" +
            "}")
    public String isVisibleClick;

    @ExecBy(js = "document.getElementById(" + Arguments.FIRST + ").click();")
    public String id;

    @ExecBy(js = "document.getElementsByClassName(" + Arguments.FIRST + ").click();")
    public String className;

    @ExecBy(js = "document.getElementsByName(" + Arguments.FIRST + ").click();")
    public String name;

    @ExecBy(js = "document.querySelector(\"*[href=" + Arguments.FIRST + "]\").click();")
    public String linkText;

    @ExecBy(js = "document.getElementsByTagName(" + Arguments.FIRST + ").click();")
    public String tagName;

    @ExecBy(js = "document.querySelectorAll(" + Arguments.FIRST + ").click();")
    public String css;

    @ExecBy(js = "var el = document.evaluate(" + Arguments.FIRST + ", document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; el.click();")
    public String xpath;

    @ExecBy(js = "for(var i=0; i < 2; i++) {" + Arguments.FIRST + ".click();}")
    public String doubleClick;
}
