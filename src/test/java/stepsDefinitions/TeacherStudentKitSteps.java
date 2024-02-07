package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import mobilePages.StudentAppHomePage;
import mobilePages.StudentAppLoginPage;
import mobilePages.TeacherAppHomePage;
import mobilePages.TeacherAppLoginPage;

import java.net.MalformedURLException;

public class TeacherStudentKitSteps {

    TeacherAppHomePage teacherAppHomePage = new TeacherAppHomePage();
    TeacherAppLoginPage teacherAppLoginPage;
    StudentAppHomePage studentAppHomePage= new StudentAppHomePage();
    StudentAppLoginPage studentAppLoginPage;

    @Given("user opens Teacher Kit app")
    public void userOpensTeacherKitApp() {
        try {
            teacherAppLoginPage= teacherAppHomePage.openTeacherKitApp();
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @When("user logins to Teacher App Kit with credentials")
    public void userLoginsToTeacherAppKitWithCredentials() {

        try {
            teacherAppLoginPage.loginWithValidCredentials();
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Given("user opens Student Kit app")
    public void userOpensStudentKitApp() {
        try {
            studentAppLoginPage= studentAppHomePage.openStudentKitApp();
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @When("user logins to Student App Kit with credentials")
    public void userLoginsToStudentAppKitWithCredentials() {
        try {
            studentAppLoginPage.loginWithValidCredentials();
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}
