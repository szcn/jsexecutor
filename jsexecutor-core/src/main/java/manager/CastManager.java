package manager;

import exception.JavaScriptExecutorException;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Objects;

public class CastManager
{
    private RemoteWebDriver remoteWebDriver;
    private WebDriver webDriver;

    @SneakyThrows
    public CastManager(Object object)
    {
        if (object instanceof WebDriver)
            {this.webDriver = (WebDriver) object;}

        else if (object instanceof RemoteWebDriver)
            {this.remoteWebDriver = (RemoteWebDriver) object;}
        else
        {
            throw new InstanceNotFoundException("Object is not instance of driver class");
        }
    }

    /*public CastManager(RemoteWebDriver remoteWebDriver)
    {
        this.remoteWebDriver = remoteWebDriver;
    }*/

    public WebElement castWebElement(Object o)
    {
        By by = (By) o;
        if (Objects.nonNull(webDriver))
        {
            return webElement(webDriver, by);
        }
        else if (Objects.nonNull(remoteWebDriver))
        {
            return webElement(remoteWebDriver, by);
        }
        else
        {
            throw new JavaScriptExecutorException("Driver is null");
        }
    }

    public List<WebElement> castWebElements(Object o)
    {
        By by = (By) o;
        if (Objects.nonNull(webDriver))
        {
            return webElements(webDriver, by);
        }
        else if (Objects.nonNull(remoteWebDriver))
        {
            return webElements(remoteWebDriver, by);
        }
        else
        {
            throw new JavaScriptExecutorException("Driver is null");
        }
    }

    private WebElement webElement(WebDriver webDriver, By by)
    {
        return webDriver.findElement(by);
    }

    private List<WebElement> webElements(WebDriver webDriver, By by)
    {
        return webDriver.findElements(by);
    }

    private WebElement webElement(RemoteWebDriver remoteWebDriver, By by)
    {
        return remoteWebDriver.findElement(by);
    }

    private List<WebElement> webElements(RemoteWebDriver remoteWebDriver, By by)
    {
        return remoteWebDriver.findElements(by);
    }
}
