package action;

import annotation.ExecBy;

public class Wait
{

    public Wait()
    {
        new JSFieldManager(this);
    }

    /**
     * wait
     **/

    @ExecBy(js = "var callback = arguments[arguments.length - 1]; var xhr = new XMLHttpRequest(); xhr.open('GET', '/Ajax_call', true); " +
            "xhr.onreadystatechange = function() {if (xhr.readyState == 4) { callback(xhr.responseText);}}; xhr.send();" )
    public String ajaxComplete;

    /**
     * Her 500 ms için kontrol eder elementi
     * Object First: element
     * Object Second : ms
     */
    @ExecBy(js = "var checkExist = setInterval(function() {\n" +
            "   if ($("+JSConstants.Objects.FIRST+").length) {\n" +
            "      console.log(\"Exists!\");\n" +
            "      clearInterval(checkExist);\n" +
            "   }\n" +
            "}, "+JSConstants.Objects.SECOND+");" )
    public String checkExist;
}
