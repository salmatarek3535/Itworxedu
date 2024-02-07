package uiPages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    protected static WebDriver driver;
    protected static UIActions uiActions;
    private By usernameLocator= By.id("Email");
    private By passwordLocator= By.id("inputPassword");
    private By loginBtnLocator= By.id("btnLogin");
    private By landingPageLocator= By.id("lblTenantDisplayName");

    public LoginPage(WebDriver driver)
    {
        this.driver= driver;
        uiActions= new UIActions(driver);
    }

    public LandingPage loginWithValidCredentials(String username, String password)
    {
        uiActions.sendText(usernameLocator, username);
        uiActions.sendText(passwordLocator, password);
        uiActions.clickOnElement(loginBtnLocator);
        uiActions.waitForElement(landingPageLocator, "presence");

        return new LandingPage(driver);

    }

}
