package uiPages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import wrappers.PropertiesFileReader;

public class CoursesPage {

    protected static WebDriver driver;
    protected static UIActions uiActions;

    private String courseName= PropertiesFileReader.getValue("courseName");
    private String subject= PropertiesFileReader.getValue("subject");
    private String grade= PropertiesFileReader.getValue("grade/year");
    private String courseTeacher= PropertiesFileReader.getValue("courseTeacher");

    private By addCourseBtnLocator= By.id("btnListAddCourse");
    private By courseNameLocator= By.id("txtCourseName");
    private By subjectLocator= By.id("courseSubject");
    private By gradeLocator= By.id("courseGrade");
    private By courseTeacherLocator2= By.xpath("//input[@placeholder='Course Teacher']");
    private By courseTeacherLocator= By.xpath("//span[text()='Course Teacher']");
    private By courseCompleteionCriteraLocator= By.xpath("//label[@for='rdFinalAssessment']/em");
    private By createCourseBtnLocator= By.id("btnSaveAsDraftCourse");
    private By coursesPageBtnLocator= By.xpath("//a[@id='btnMyCoursesList']/em");
    private By coursesOrderByLocator= By.id("CoursesOrderBy");
    private  By courseTitleLocator = By.xpath(String.format("//a[@id='lnkListCourseSelcted'][text()='%s']",courseName));


    public CoursesPage(WebDriver driver)
    {
        this.driver= driver;
        uiActions= new UIActions(driver);
    }

    public void addNewCourse()
    {
        uiActions.clickOnElement(addCourseBtnLocator);
    }

    public void fillCourseDetails()
    {
        uiActions.sendText(courseNameLocator,courseName);
        uiActions.selectFromDropDownList(subjectLocator,subject);
        uiActions.selectFromDropDownList(gradeLocator,grade);
        uiActions.clickOnElement(courseTeacherLocator);
        uiActions.sendTextUsingJS(courseTeacherLocator2,courseTeacher);
        uiActions.clickOnElement(courseCompleteionCriteraLocator);
        uiActions.clickOnElement(createCourseBtnLocator);
    }

    public void assertCourseTitle()
    {
        uiActions.clickOnElement(coursesPageBtnLocator);
        uiActions.selectFromDropDownList(coursesOrderByLocator,"Creation Date Descending");
        Assert.assertTrue(uiActions.locateElement(courseTitleLocator).isDisplayed(),"Course title not found!");
    }
}
