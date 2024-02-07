package stepsDefinitions;

import base.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiPages.CoursesPage;
import uiPages.LandingPage;
import wrappers.PropertiesFileReader;

public class WinjigoSteps extends BaseTests{

    private final String username= PropertiesFileReader.getValue("username");
    private final String password= PropertiesFileReader.getValue("password");
    private final BaseTests baseTests= new BaseTests();
    private LandingPage landingPage;
    private CoursesPage coursesPage;

    @Given("user opens winjigo website")
    public void userOpensWinjigoWebsite() {
        baseTests.setUp();
    }

    @Given("user logins to winjigo website using valid username and password")
    public void userLoginsToWinjigoWebsiteUsingValidAnd() {
        landingPage= loginPage.loginWithValidCredentials(username,password);
    }

    @When("user opens courses page from left side navigation bar")
    public void userOpensCoursesPageFromLeftSideNavigationBar() {
        coursesPage= landingPage.openCoursesPage();
    }

    @And("user clicks on Add Course button")
    public void userClicksOnAddCourseButton() {
        coursesPage.addNewCourse();
    }

    @And("user fill course details and add it")
    public void userFillCourseDetailsAndAddIt() {
        coursesPage.fillCourseDetails();
    }

    @Then("user validate that the created course title appears in the courses page")
    public void userValidateThatTheCreatedCourseTitleAppearsInTheCoursesPage() {
        coursesPage.assertCourseTitle();
    }

    @Then("user close the browser")
    public void userCloseTheBrowser() {
        baseTests.tearDown();
    }
}
