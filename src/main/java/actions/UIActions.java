package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class UIActions {

    private WebDriver driver;


    public UIActions(WebDriver driver)
    {
        this.driver= driver;
    }

    public boolean waitForElement(By locator, String waiting_condition)
    {
        try
        {
            switch (waiting_condition)
            {
                case "presence":

                    new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.
                            presenceOfElementLocated(locator));
                    break;

                case "visibility":

                    new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.
                            visibilityOfElementLocated(locator));
                    break;

                case "clickable":
                    new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.
                            elementToBeClickable(locator));
                    break;
            }

            return true;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public WebElement locateElement(By locator)
    {
        waitForElement(locator, "presence");
        return driver.findElement(locator);
    }

    public List<WebElement> getElementsForSpecificLocator(By locator)
    {
        return driver.findElements(locator);
    }

    public void clickElement(By locator, String waiting_condition, By Expected, String Expected_waiting_condition)
    {
         boolean result= waitForElement(locator,waiting_condition);
         if(result== true)
         {
             //clickOnElement(locator);
             driver.findElement(locator).click();
             result= waitForElement(Expected,Expected_waiting_condition); // put it in the other action
         }
    }

    public void clickOnElement(By locator)
    {
        if(waitForElement(locator,"clickable"))
        driver.findElement(locator).click();
    }

    public String getElementText(By locator)
    {
        return driver.findElement(locator).getText();
    }

    public void sendText(By locator, String text)
    {
        if(waitForElement(locator,"presence"))
        driver.findElement(locator).sendKeys(text);
    }

    public void sendTextUsingJS(By locator, String text)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(String.format("arguments[0].value='%s';",text), driver.findElement(locator));
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public String getALertText()
    {
        return driver.switchTo().alert().getText();
    }

    public void closeALert()
    {
        driver.switchTo().alert().dismiss();
    }

    public void selectFromDropDownList(By locator, String selector)
    {
        if(waitForElement(locator,"presence"))
        {
            Select select= new Select(driver.findElement(locator));
            select.selectByVisibleText(selector);
        }
    }


}
