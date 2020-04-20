package util;

import annotation.ExecBy;
import executor.JavaScriptExecutor;
import manager.BuilderManager;
import org.openqa.selenium.WebDriver;

public class Purview
{
    public Purview()
    {
        new BuilderManager(getClass().getEnclosingClass());
    }

    @ExecBy(js = "const rect = arguments[0].getBoundingClientRect();" +
            "const windowHeight = (window.innerHeight || document.documentElement.clientHeight);" +
            "const windowWidth = (window.innerWidth || document.documentElement.clientWidth);" +
            "const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0);" +
            "const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0);")
    public static String element;

    public static boolean purview(String piece, WebDriver driver){

        JavaScriptExecutor javaScriptExecutor = new JavaScriptExecutor(driver);

        return javaScriptExecutor.executeScript(Boolean.class,element,piece);

    }

}
