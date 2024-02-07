package mobilePages;

import actions.UIActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import wrappers.PropertiesFileReader;
import java.net.MalformedURLException;

public class StudentAppLoginPage {

    private AndroidDriver driver;
    private UIActions uiActions;

    private static final By emailLocator= By.id("com.itworx.winjigostudent:id/emailView");
    private static final By passwordLocator= By.id("com.itworx.winjigostudent:id/passwordView");
    private static final By loginBtnLocator= By.id("com.itworx.winjigostudent:id/buttonLogin");
    private static final String email= PropertiesFileReader.getValue("studentEmail");
    private static final String password= PropertiesFileReader.getValue("studentPassword");



    public StudentAppLoginPage(AndroidDriver driver)
    {
        this.driver= driver;
        uiActions= new UIActions(driver);
    }


    public void loginWithValidCredentials() throws MalformedURLException {

        uiActions.sendText(emailLocator,email);
        uiActions.sendText(passwordLocator,password);
        uiActions.clickOnElement(loginBtnLocator);
        System.out.println(driver.getCapabilities().getCapabilityNames());
    }

}
