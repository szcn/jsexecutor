package action;


import annotation.ExecBy;

public class Random
{
    public Random()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "return generate_random_string(" + JSConstants.Objects.FIRST + ")\n" +
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

    @ExecBy(js = "return Math.floor(Math.random() * Math.floor(Math.pow(10, " + JSConstants.Objects.FIRST + ")))")
    public String numberGenerate;

    @ExecBy(js =
            "var text = \"\"; var possible = \"abcdefghijklmnopqrstuvwxyz0123456789\"; for (var i = 0; i < " + JSConstants.Objects.FIRST + ";" +
                    " i++) text += possible.charAt(Math.floor(Math.random() * possible.length)); return text;")
    public String mixedGenerate;

    @ExecBy(js = "var element = document.getElementsByClassName(" + JSConstants.Objects.FIRST + "); var index = " +
            "Math.floor((Math.random() * element.length)); element[index].click()")
    public String elementClickByClassName;

    @ExecBy(js = "var element = document.getElementsByName(" + JSConstants.Objects.FIRST + "); var index = Math" +
            ".floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByName;

    @ExecBy(js = "var element = document.getElementsByTagName(" + JSConstants.Objects.FIRST + "); var index = Math" +
            ".floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByTagName;

    @ExecBy(js = "var element = document.querySelectorAll(\"*[href=" + JSConstants.Objects.FIRST + "]\"); var index" +
            " = Math.floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByLinkText;

    @ExecBy(js = "var element = document.querySelectorAll(" + JSConstants.Objects.FIRST + "); var index = Math" +
            ".floor((Math.random() * element.length)); element[index].click()")
    public String randomElementClickByCSS;

    @ExecBy(jquery = "var result = document.evaluate(" + JSConstants.Objects.FIRST + "\", document, null, " +
            "XPathResult.ANY_TYPE, null); var node, nodes = [] while (node = result.iterateNext()) " +
            "nodes.push(node); var index = Math.floor((Math.random() * nodes.length)); nodes[index].click()")
    public String randomElementClickByXpath;
}
