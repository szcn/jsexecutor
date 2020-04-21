package action;

import constants.Constants.Arguments;
import annotation.ExecBy;
import manager.BuilderManager;

public class Displayed
{
    public Displayed()
    {
        new BuilderManager(this);
    }

    @ExecBy(js = "function isVisible(elem) {\n" +
            "    if (!(elem instanceof Element)) throw Error('DomUtil: elem is not an element.');\n" +
            "    const style = getComputedStyle(elem);\n" +
            "    if (style.display === 'none') return false;\n" +
            "    if (style.visibility !== 'visible') return false;\n" +
            "    if (style.opacity < 0.1) return false;\n" +
            "    if (elem.offsetWidth + elem.offsetHeight + elem.getBoundingClientRect().height +\n" +
            "        elem.getBoundingClientRect().width === 0) {\n" +
            "        return false;\n" +
            "    }\n" +
            "    const elemCenter   = {\n" +
            "        x: elem.getBoundingClientRect().left + elem.offsetWidth / 2,\n" +
            "        y: elem.getBoundingClientRect().top + elem.offsetHeight / 2\n" +
            "    };\n" +
            "    if (elemCenter.x < 0) return false;\n" +
            "    if (elemCenter.x > (document.documentElement.clientWidth || window.innerWidth)) return false;\n" +
            "    if (elemCenter.y < 0) return false;\n" +
            "    if (elemCenter.y > (document.documentElement.clientHeight || window.innerHeight)) return false;\n" +
            "    let pointContainer = document.elementFromPoint(elemCenter.x, elemCenter.y);\n" +
            "    do {\n" +
            "        if (pointContainer === elem) return true;\n" +
            "    } while (pointContainer = pointContainer.parentNode);\n" +
            "    return false;\n" +
            "}\n" +
            "return isVisible(" + Arguments.FIRST + ")")
    public String isDisplayed;


}
