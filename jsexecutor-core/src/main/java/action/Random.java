package action;

import constants.Constants.Arguments;
import annotation.Exec;
import manager.BuilderManager;

public class Random
{
    public Random()
    {
        new BuilderManager(this);
    }

    @Exec(js = "return generate_random_string(" + Arguments.FIRST + ")\n" +
            "\n" +
            "function generate_random_string(length){\n" +
            "    let random_string = '';\n" +
            "    let random_ascii;\n" +
            "    for(let i = 0; i < length; i++) {\n" +
            "        random_ascii = Math.floor((Math.random() * 25) + 97);\n" +
            "        random_string += String.fromCharCode(random_ascii)\n" +
            "    }\n" +
            "    return random_string }")
    public String stringGenerate;

    @Exec(js = "return Math.floor(Math.random() * Math.floor(Math.pow(10, " + Arguments.FIRST + ")))")
    public String numberGenerate;

    @Exec(js =
            "var text = \"\"; var possible = \"abcdefghijklmnopqrstuvwxyz0123456789\"; for (var i = 0; i < " + Arguments.FIRST + ";" +
                    " i++) text += possible.charAt(Math.floor(Math.random() * possible.length)); return text;")
    public String mixedGenerate;

    @Exec(js = "var element = document.getElementsByClassName(" + Arguments.FIRST + "); var index = " +
            "Math.floor((Math.random() * element.length)); element[index].click()")
    public String elementClickByClassName;

    @Exec(js = "var element = document.getElementsByName(" + Arguments.FIRST + "); var index = Math" +
            ".floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByName;

    @Exec(js = "var element = document.getElementsByTagName(" + Arguments.FIRST + "); var index = Math" +
            ".floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByTagName;

    @Exec(js = "var element = document.querySelectorAll(\"*[href=" + Arguments.FIRST + "]\"); var index" +
            " = Math.floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByLinkText;

    @Exec(js = "var element = document.querySelectorAll(" + Arguments.FIRST + "); var index = Math" +
            ".floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByCSS;

    @Exec(jquery = "var result = document.evaluate(" + Arguments.FIRST + "\", document, null, " +
            "XPathResult.ANY_TYPE, null); var node, nodes = [] while (node = result.iterateNext()) " +
            "nodes.push(node); var index = Math.floor((Math.random() * nodes.length)); nodes[index].click()")
    public String randomElementClickByXpath;
}
