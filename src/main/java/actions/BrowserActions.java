package actions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserActions {

   private WebDriver driver;
   public By locator= By.xpath("//span[text()='WinjiGo']");

   public WebDriver driverInit(String browser)
   {

       switch(browser)
       {
           case "chrome":
               driver = new ChromeDriver();
               break;

           case "firefox":
                driver = new FirefoxDriver();
	            break;

           case "edge":
               driver = new EdgeDriver();
               break;

       }
       return driver;
}

   public void maximizeWindow()
   {
       driver.manage().window().maximize();
   }

   public void navigateToURL(String URL)
   {
       UIActions action= new UIActions(driver);
       boolean result= false;
       int i=0;
       do
       {
           driver.get(URL); //navigate
           result= action.waitForElement(locator,"presence");
           i++;

       }while(result!= true && i<3);
   }

   public void quitBrowser(WebDriver driver1)
   {
       driver1.quit();
   }

}
