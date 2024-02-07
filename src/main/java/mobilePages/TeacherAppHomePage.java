package mobilePages;

import actions.UIActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import wrappers.PropertiesFileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TeacherAppHomePage {

    private AndroidDriver driver;
    private UIActions uiActions;

    private static final String deviceName= PropertiesFileReader.getValue("deviceName");
    private static final String udid= PropertiesFileReader.getValue("udid");
    private static final String platformName= PropertiesFileReader.getValue("platformName");
    private static final String platformVersion= PropertiesFileReader.getValue("platformVersion");
    private static final String appPackage= PropertiesFileReader.getValue("teacherAppPackage");
    private static final String appActivity= PropertiesFileReader.getValue("teacherAppActivity");
    private static final String appiumUrl= PropertiesFileReader.getValue("appiumUrl");

    private static final By getStartedBtnLocator= By.id("com.itworx.winjigoteacher:id/buttonSignIn");





    public TeacherAppLoginPage openTeacherKitApp() throws MalformedURLException {

        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);


        URL url= new URL(appiumUrl);
        driver= new AndroidDriver(url,capabilities);
        uiActions= new UIActions(driver);
        uiActions.clickOnElement(getStartedBtnLocator);

        return new TeacherAppLoginPage(driver);
    }
}
