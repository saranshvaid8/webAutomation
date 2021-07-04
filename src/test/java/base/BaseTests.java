package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTests {

    private WebDriver driver;
    private static final String URL = "https://the-internet.herokuapp.com/";
    private static final  String PAGE_TITLE = "The Internet";

    @BeforeTest
    public void beforeTestSetUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
       }

     @AfterTest
     public void afterTestSetUp(){
        driver.quit();
        driver.close();
     }

    @Test
    public void verifyPageTitleIsDisplayed(){
        driver.get(URL);
        String actualPageTitle = driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(PAGE_TITLE, actualPageTitle);
    }
}
