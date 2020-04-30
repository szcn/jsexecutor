package executor;

import action.Attribute;
import action.CheckBox;
import action.Click;
import action.Displayed;
import action.MouseOver;
import action.Random;
import action.Select;
import action.TextField;
import action.Wait;
import action.Zoom;
import constants.Constants;
import constants.Regex;
import executor.impl.JavaScriptExecutorImpl;
import lombok.extern.slf4j.Slf4j;
import manager.BuilderManager;
import manager.CastManager;
import manager.ScriptEngineManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import util.DataType;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class JavaScriptExecutor implements JavaScriptExecutorImpl
{
    private final JavascriptExecutor jExecutor;
    private final WebDriver driver;
    /*private final RemoteWebDriver remoteWebDriver;*/

    public JavaScriptExecutor(WebDriver driver)
    {
        this.driver = driver;
        this.jExecutor = (JavascriptExecutor) driver;
    }

    /*public JavaScriptExecutor(RemoteWebDriver remoteWebDriver)
    {
        this.remoteWebDriver = remoteWebDriver;
        this.jExecutor = (JavaScriptExecutor) remoteWebDriver;
    }*/

    @Override
    public JavaScriptExecutor getDriver(WebDriver driver)
    {

        return (JavaScriptExecutor) driver;

    }

    @Override
    public <T> T executeScript(Class<T> clazz, String script, Object... args)
    {

        //log.info("*** JavaScript Info : { " + script + " }", "Argument Info : { " + args + " }");

        return clazz.cast(jExecutor.executeScript(script, args));
    }

    @Override
    public JavaScriptExecutor executeScript(String script, Object... args)
    {

        //log.info("*** JavaScript Info : { " + script + " }", "Argument Info : { " + args + " }");
        jExecutor.executeScript(script, args);

        return this;

    }

    @Override
    public JavaScriptExecutor executeScriptWithinFile(String var) throws IOException
    {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

        jExecutor.executeScript(scriptEngineManager.eval(var));

        return this;
    }

    @Override
    public <T> T executeScriptWithinFile(Class<T> clazz, String var) throws IOException
    {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();


        return clazz.cast(jExecutor.executeScript(scriptEngineManager.eval(var)));
    }


    @Override
    public JavaScriptExecutor goToUrl(String url)
    {
        return executeScript(Constants.GoToUrl.HREF, url);
    }

    /**
     * Constants.LocalStorage
     **/

    @Override
    public void removeItemFromLocalStorage(String item)
    {
        executeScript(String.format(Constants.LocalStorage.REMOVE_ITEM, item));
    }

    @Override
    public boolean isItemPresentInLocalStorage(String item)
    {
        return !(executeScript(String.format(Constants.LocalStorage.GET_ITEM, item)) == null);
    }

    @Override
    public String getItemFromLocalStorage(String item)
    {
        return executeScript(String.class, String.format(Constants.LocalStorage.GET_ITEM, item));
    }

    @Override
    public String getKeyFromLocalStorage(int key)
    {
        return String.valueOf(executeScript(String.format(Constants.LocalStorage.GET_KEY, key)));
    }

    @Override
    public Long getLocalStorageLength()
    {
        return Long.valueOf(String.valueOf(executeScript(Constants.LocalStorage.LENGTH)));
    }

    public void setItemInLocalStorage(String item, String value)
    {
        executeScript(String.format(Constants.LocalStorage.SET_ITEM, item, value));
    }

    @Override
    public void clearLocalStorage()
    {
        executeScript(String.format(Constants.LocalStorage.CLEAR));
    }

    /**
     * Constants.SessionStorage
     **/

    @Override
    public void removeItemFromSessionStorage(String item)
    {
        executeScript(String.format(Constants.SessionStorage.REMOVE_ITEM, item));
    }

    @Override
    public boolean isItemPresentInSessionStorage(String item)
    {
        if (executeScript(String.format(
                Constants.SessionStorage.GET_ITEM, item)) == null)
            return false;
        else
            return true;
    }

    @Override
    public String getItemFromSessionStorage(String key)
    {
        return String.valueOf(executeScript(String.format(
                Constants.SessionStorage.GET_ITEM, key)));
    }

    @Override
    public String getKeyFromSessionStorage(int key)
    {
        return String.valueOf(executeScript(String.format(
                Constants.SessionStorage.GET_KEY, key)));
    }

    @Override
    public Long getSessionStorageLength()
    {
        return Long.valueOf(String.valueOf(executeScript(Constants.SessionStorage.LENGTH)));
    }

    @Override
    public void setItemInSessionStorage(String item, String value)
    {
        executeScript(String.format(Constants.SessionStorage.SET_ITEM, item, value));
    }

    @Override
    public void clearSessionStorage()
    {
        executeScript(String.format(Constants.SessionStorage.CLEAR));
    }

    /**
     * Constants.Scroll
     **/

    @Override
    public JavaScriptExecutor scrollWithElement(WebElement element)
    {
        return executeScript(Constants.Scroll.VIEW, element);
    }

    @Override
    public JavaScriptExecutor scrollHorizontally(int value)
    {
        return executeScript(Constants.Scroll.HORIZONTALLY, value);
    }

    @Override
    public JavaScriptExecutor scrollVertically(int value)
    {
        return executeScript(Constants.Scroll.VERTICALLY, value);
    }

    @Override
    public JavaScriptExecutor scrollHorizontallyAndVertically(int h, int v)
    {
        return executeScript(Constants.Scroll.HORIZONTALLY_AND_VERTICALLY, h, v);
    }

    @Override
    public JavaScriptExecutor scrollDown()
    {
        return executeScript(Constants.Scroll.DOWN);
    }

    @Override
    public JavaScriptExecutor scrollUp()
    {
        return executeScript(Constants.Scroll.UP);
    }

    @Override
    public JavaScriptExecutor scrollPageCenter()
    {
        return executeScript(Constants.Scroll.PAGE_CENTER);
    }

    /**
     * Click
     **/

    @Override
    public JavaScriptExecutor click(Object object)
    {
        Click click = new Click();

        if (object instanceof By)
        {
            ///TODO : remotedriver
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(click.isVisibleClick, object);
    }

    @Override
    public JavaScriptExecutor forceClick(Object object)
    {
        Click click = new Click();

        BuilderManager builderManager = new BuilderManager();

        How type = builderManager.assertValidFindType(object);
        String locatorValue = builderManager.finderValue(object);

        switch (type)
        {
            case CLASS_NAME:
                return executeScript(click.className, locatorValue);
            case CSS:
                return executeScript(click.css, locatorValue);
            case ID:
                return executeScript(click.id, locatorValue);
            case LINK_TEXT:
            case PARTIAL_LINK_TEXT:
                return executeScript(click.linkText, locatorValue);
            case NAME:
                return executeScript(click.name, locatorValue);
            case TAG_NAME:
                return executeScript(click.tagName, locatorValue);
            case XPATH:
                return executeScript(click.xpath, locatorValue);
        }

        return executeScript(click.isVisibleClick, object);
    }

    @Override
    public JavaScriptExecutor click(List<WebElement> object, int index)
    {

        BuilderManager builderManager = new BuilderManager();
        String locatorValue;

        Click click = new Click();

        How type = builderManager.assertValidFindType(object);

        if (type.equals(How.XPATH))
            locatorValue = object.toString().split(Regex.FINDER_TYPE_FOR_WEB_ELEMENT)[1].split("[\\]]{" + (object.size() - 1) + "}$")[0];
        else
            locatorValue = builderManager.finderValue(object).split("]")[0];

        switch (type)
        {
            case CLASS_NAME:
                return executeScript(click.classNameAll, locatorValue, index);
            case CSS:
                return executeScript(click.cssAll, locatorValue, index);
            case ID:
                return executeScript(click.idAll, locatorValue, index);
            case LINK_TEXT:
            case PARTIAL_LINK_TEXT:
                return executeScript(click.linkTextAll, locatorValue, index);
            case NAME:
                return executeScript(click.nameAll, locatorValue, index);
            case TAG_NAME:
                return executeScript(click.tagNameAll, locatorValue, index);
            case XPATH:
                return executeScript(click.xpathAll, locatorValue, index);
        }

        return executeScript(null);

    }

    @Override
    public JavaScriptExecutor doubleClick(Object object)
    {
        Click click = new Click();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(click.doubleClick, object);
    }

    @Override
    public JavaScriptExecutor randomElementClick(List<Object> objects)
    {
        BuilderManager builderManager = new BuilderManager();

        Random random = new Random();

        How type = builderManager.assertValidFindType(objects);
        String locatorValue = builderManager.finderValue(objects);

        switch (type)
        {
            case CLASS_NAME:
                return executeScript(random.elementClickByClassName, locatorValue);
            case CSS:
                return executeScript(random.randomElementClickByCSS, locatorValue);
            case LINK_TEXT:
            case PARTIAL_LINK_TEXT:
                return executeScript(random.randomElementClickByLinkText, locatorValue);
            case NAME:
                return executeScript(random.randomElementClickByName, locatorValue);
            case TAG_NAME:
                return executeScript(random.randomElementClickByTagName, locatorValue);
            case XPATH:
                return executeScript(random.randomElementClickByXpath, locatorValue);
        }

        return executeScript(null);
    }

    @Override
    public boolean isCheckBoxChecked(Object object)
    {
        CheckBox checkBox = new CheckBox();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(Boolean.class, checkBox.checkBoxChecked, object);
    }

    @Override
    public boolean isCheckedAllCheckBox()
    {
        CheckBox checkBox = new CheckBox();
        return executeScript(Boolean.class, checkBox.checkedControl);
    }

    @Override
    public JavaScriptExecutor checkAllCheckBox()
    {
        CheckBox checkBox = new CheckBox();
        return executeScript(checkBox.allClick);
    }

    @Override
    public JavaScriptExecutor setValue(Object object, String value)
    {
        return executeScript(Constants.SetValue.SEND_KEYS, object, value);
    }

    //TODO : fixme
    @Override
    public JavaScriptExecutor sleep(int milliseconds)
    {
        return executeScript(Constants.DelayedGreeting.SLEEP, (milliseconds*1000));
    }

    /**
     * Clear
     **/

    @Override
    public JavaScriptExecutor clear(Object object)
    {
        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(Constants.Clear.CLEAR, object);
    }

    /**
     * getText
     **/

    @Override
    public String getText(Object object)
    {
        TextField textField = new TextField();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(String.class, textField.getText, object);
    }

    /**
     * Assertions
     **/

    @Override
    public JavaScriptExecutor assertTrue(boolean value)
    {
        assertThat(value).isTrue();
        return this;
    }

    @Override
    public boolean isDisplayed(Object object)
    {
        Displayed displayed = new Displayed();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(Boolean.class, displayed.isDisplayed, object);
    }

    @Override
    public JavaScriptExecutor assertFalse(boolean value)
    {
        assertThat(value).isFalse();
        return this;
    }

    @Override
    public JavaScriptExecutor assertEqual(String expected, String actual)
    {
        assertThat(actual).isEqualTo(expected);
        return this;
    }

    @Override
    public boolean isAttributePresent(Object object, Object attributeName)
    {
        Attribute attribute = new Attribute();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(Boolean.class, attribute.isAttributePresent, object, attributeName);
    }

    /**
     * New Open Tab
     **/

    @Override
    public JavaScriptExecutor newTab(String url)
    {
        return executeScript(Constants.NewTab.NEW_TAB, url);
    }

    /**
     * Random Generate
     **/

    @Override
    public Object randomGenerate(DataType dataType, int length)
    {

        Random random = new Random();

        switch (dataType)
        {
            case STRING:
                return executeScript(String.class, random.stringGenerate, length);
            case NUMBER:
                return executeScript(Number.class, random.numberGenerate, length);
            case MIXED:
                return executeScript(String.class, random.mixedGenerate, length);

            default:
                return "There is not Data Type = " + dataType;
        }
    }

    /**
     * Select
     **/

    @Override
    public JavaScriptExecutor selectByValue(Object object, Object valueName)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(select.selectByValue, object, valueName);
    }

    @Override
    public JavaScriptExecutor selectByIndex(Object object, Object index)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(select.selectByIndex, object, index);
    }

    @Override
    public String getSelectedOptionVisibleText(Object object)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(String.class, select.getSelectedOptionVisibleText, object);
    }

    @Override
    public Number getSelectedOptionIndex(Object object)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(Number.class, select.getSelectedOptionIndex, object);
    }

    @Override
    public String getSelectedOptionValue(Object object)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(String.class, select.getSelectedOptionValue, object);
    }

    @Override
    public List<Object> getSelectBoxOptionsValue(Object object)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(List.class, select.getOptionsValue, object);
    }

    @Override
    public List<Object> getSelectBoxOptionsText(Object object)
    {
        Select select = new Select();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(List.class, select.getOptionsText, object);
    }

    /**
     * Get Value
     **/

    @Override
    public String getAttribute(Object object, Object attributeName)
    {
        Attribute attribute = new Attribute();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(String.class, attribute.getAttribute, object, attributeName);
    }

    /**
     * Zoom
     **/

    @Override
    public JavaScriptExecutor pageZoom(int percentValue)
    {
        Zoom zoom = new Zoom();
        return executeScript(zoom.pageZoom, percentValue);
    }

    /**
     * Mouse Over
     **/

    @Override
    public JavaScriptExecutor mouseOver(Object object)
    {
        BuilderManager builderManager = new BuilderManager();
        MouseOver mouseOver = new MouseOver();

        How type = builderManager.assertValidFindType(object);
        String locatorValue = builderManager.finderValue(object);

        switch (type)
        {
            case CLASS_NAME:
                return executeScript(mouseOver.className, locatorValue);
            case CSS:
                return executeScript(mouseOver.css, locatorValue);
            case ID:
                return executeScript(mouseOver.id, locatorValue);
            case LINK_TEXT:
            case PARTIAL_LINK_TEXT:
                return executeScript(mouseOver.linkText, locatorValue);
            case NAME:
                return executeScript(mouseOver.name, locatorValue);
            case TAG_NAME:
                return executeScript(mouseOver.tagName, locatorValue);
            case XPATH:
                return executeScript(mouseOver.xpath, locatorValue);


            default:
                return null;

        }

    }

    /**
     * Page Refresh
     **/

    @Override
    public JavaScriptExecutor pageRefresh()
    {
        return executeScript(Constants.PageRefresh.REFRESH);
    }

    /**
     * Get Location Path Name "www.siteName.com/LOCATION_PATH_NAME"
     **/

    @Override
    public String getLocationPathName()
    {
        return executeScript(String.class, Constants.GetLocationPathName.LOCATION_PATH_NAME);
    }


    @Override
    public String getCurrentUrl()
    {
        return executeScript(String.class, Constants.GetCurrentUrl.CURRENT_URL);
    }

    /**
     * Wait
     */
    @Override
    public JavaScriptExecutor ajaxComplete()
    {
        Wait wait = new Wait();
        return executeScript(wait.ajaxComplete);
    }

    @Override
    public JavaScriptExecutor checkExist(Object object, int millisecond)
    {
        Wait wait = new Wait();

        if (object instanceof By)
        {
            CastManager castManager = new CastManager(driver);

            object = castManager.castWebElement(object);
        }

        return executeScript(wait.checkExist, object, millisecond);
    }

    @Override
    public String decode(String text)
    {
        return executeScript(String.class, Constants.Decode.DECODE, text);
    }

}
