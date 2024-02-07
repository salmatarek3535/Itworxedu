package base;

import actions.BrowserActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import uiPages.LoginPage;
import wrappers.PropertiesFileReader;

public class BaseTests extends AbstractTestNGCucumberTests
{
    protected static WebDriver driver;
    private BrowserActions browserActions =new BrowserActions();
    protected static LoginPage loginPage;

    /****************************** using properties file *******************************/
    private String URL= PropertiesFileReader.getValue("url");
    private static final String browser= "chrome";

    /****************************** initialize the driver them open the website *******************************/
    public void setUp()
    {
        driver= browserActions.driverInit(browser);
        browserActions.maximizeWindow();
        browserActions.navigateToURL(URL);
        loginPage= new LoginPage(driver);
    }

    /****************************** close all opened browser tabs *******************************/
    public void tearDown()
    {
        browserActions.quitBrowser(driver);
    }

}
