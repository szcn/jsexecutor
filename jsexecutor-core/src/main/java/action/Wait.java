package action;

import annotation.Exec;
import constants.Constants.Arguments;
import manager.BuilderManager;

public class Wait
{

    public Wait()
    {
        new BuilderManager(this);
    }

    @Exec(js = "var callback = arguments[arguments.length - 1]; var xhr = new XMLHttpRequest(); xhr.open('GET', '/Ajax_call', true); " +
            "xhr.onreadystatechange = function() {if (xhr.readyState == 4) { callback(xhr.responseText);}}; xhr.send();" )
    public String ajaxComplete;

    /**
     * tries for X ms with 500 milliseconds interval
     * Object First: element
     * Object Second : ms
     */
    @Exec(js = "var checkExist = setInterval(function() {\n" +
            "   if ($("+Arguments.FIRST+").length) {\n" +
            "      console.log(\"Exists!\");\n" +
            "      clearInterval(checkExist);\n" +
            "   }\n" +
            "}, "+Arguments.SECOND+");" )
    public String checkExist;
}
