package uiPages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    protected static WebDriver driver;
    protected static UIActions uiActions;
    private By coursesPageBtnLocator= By.xpath("//a[@id='btnMyCoursesList']/em");
    private By coursesPageLocator= By.cssSelector("h1[class='color-side']");

    public LandingPage(WebDriver driver)
    {
        this.driver= driver;
        uiActions= new UIActions(driver);
    }

    public CoursesPage openCoursesPage()
    {
        uiActions.clickOnElement(coursesPageBtnLocator);
        uiActions.waitForElement(coursesPageLocator, "presence");
        return new CoursesPage(driver);
    }
}
