package executor.impl;

import executor.JavaScriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DataType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * JavaScript Executor implements
 */
public interface JavaScriptExecutorImpl
{
    JavaScriptExecutor getDriver(WebDriver driver);

    JavaScriptExecutor executeScript(String script, Object... args);

    <T> T executeScript(Class<T> clazz, String script, Object... args);

    JavaScriptExecutor executeScriptWithinFile(String var) throws IOException, URISyntaxException;

    <T> T executeScriptWithinFile(Class<T> clazz, String var) throws IOException, URISyntaxException;

    /**
     * LocalStorage
     * @param item item
     **/

    void removeItemFromLocalStorage(String item);

    boolean isItemPresentInLocalStorage(String item);

    String getItemFromLocalStorage(String item);

    String getKeyFromLocalStorage(int key);

    Long getLocalStorageLength();

    void setItemInLocalStorage(String item, String value);

    void clearLocalStorage();

    /**
     * SessionStorage
     * @param item item
     **/

    void removeItemFromSessionStorage(String item);

    boolean isItemPresentInSessionStorage(String item);

    String getItemFromSessionStorage(String key);

    String getKeyFromSessionStorage(int key);

    Long getSessionStorageLength();

    void setItemInSessionStorage(String item, String value);

    void clearSessionStorage();

    /**
     * Scroll
     * @param element WebElement
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor scrollWithElement(WebElement element);

    JavaScriptExecutor scrollHorizontally(int value);

    JavaScriptExecutor scrollVertically(int value);

    JavaScriptExecutor scrollHorizontallyAndVertically(int h, int v);

    JavaScriptExecutor scrollDown();

    JavaScriptExecutor scrollUp();

    JavaScriptExecutor scrollPageCenter();

    /**
     * Click
     * @param object WebElement
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor click(Object object);

    JavaScriptExecutor forceClick(Object object);

    JavaScriptExecutor click(List<WebElement> object, int index);

    JavaScriptExecutor doubleClick(Object object);

    JavaScriptExecutor randomElementClick(List<Object> objects);


    /** ElementIsDisplayed
     * @param script script
     **/

    //boolean isDisplayed(String script);

    /**
     * Url
     * @param url url
     * @return JavaScriptExecutor
     **/
    JavaScriptExecutor goToUrl(String url);

    /**
     * Set Value
     * @param object WebElement
     * @param value value
     * @return JavaScriptExecutor
     **/
    JavaScriptExecutor setValue(Object object, String value);

    JavaScriptExecutor sleep(int time);

    JavaScriptExecutor assertTrue(boolean value);

    JavaScriptExecutor assertFalse(boolean value);

    JavaScriptExecutor assertEqual(String expected, String actual);

    JavaScriptExecutor clear(Object object);

    /**
     * Get Value
     * @param object WebElement
     * @return String
     **/

    String getText(Object object);

    /**
     * checkbox
     * @param object WebElement
     * @return boolean
     **/

    boolean isCheckBoxChecked(Object object);

    boolean isCheckedAllCheckBox();

    JavaScriptExecutor checkAllCheckBox();

    /**
     * Assert
     * @param object WebElement
     * @return boolean
     **/

    boolean isDisplayed(Object object);

    /**
     * Is Attribute Present
     * @param object WebElement
     * @param attributeName attribute
     * @return boolean
     **/

    boolean isAttributePresent(Object object, Object attributeName);

    /**
     * Open Tab
     * @param url url
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor newTab(String url);

    /**
     * Random Generate
     * @param dataType string, mix and number
     * @param length generate l
     * @return Object
     **/

    Object randomGenerate(DataType dataType, int length);

    /**
     * Select
     * @param object WebElement
     * @param valueName value
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor selectByValue(Object object, Object valueName);

    JavaScriptExecutor selectByIndex(Object object, Object index);

    List<Object> getSelectBoxOptionsValue(Object object);

    Object getSelectBoxOptionsText(Object object);

    /**
     * Selected Option
     * @param object WebElement
     * @return String
     **/

    String getSelectedOptionVisibleText(Object object);

    Number getSelectedOptionIndex(Object object);

    String getSelectedOptionValue(Object object);

    /**
     * Get Attribute
     * @param object WebElement
     * @param attributeName attr
     * @return Object
     **/

    Object getAttribute(Object object, Object attributeName);

    /**
     * Zoom
     * @param percentValue percentValue
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor pageZoom(int percentValue);

    /**
     * Mouse Over
     * @param object WebElement
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor mouseOver(Object object);

    /**
     * Page Refresh
     * @return JavaScriptExecutor
     **/

    JavaScriptExecutor pageRefresh();

    /**
     * Get Location Path Name "www.siteName.com/LOCATION_PATH_NAME"
     * @return String
     **/

    String getLocationPathName();

    /**
     * Get Current URL
     * @return String
     **/

    String getCurrentUrl();

    /**
     * wait
     * @return JavaScriptExecutor
     */
    JavaScriptExecutor ajaxComplete();

    /**
     * @param object WebElement
     * @param millisecond ms
     * @return JavaScriptExecutor
     */
    JavaScriptExecutor checkExist(Object object, int millisecond);

    /**
     * encode - decode
     * @param text t
     * @return JavaScriptExecutor
     */

    String decode(String text);

}
