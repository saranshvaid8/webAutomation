package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class BaseTests {

    private WebDriver driver;
    private static final String URL = "https://the-internet.herokuapp.com/";
    private static final  String PAGE_TITLE = "The Internet";

    @BeforeTest
    public void beforeTestSetUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
       }

     @AfterTest
     public void afterTestSetUp(){
        driver.close();
        driver.quit();
     }

    @Test
    public void verifyPageTitleIsDisplayed(){

        String actualPageTitle = driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(PAGE_TITLE, actualPageTitle);
    }

    @Test
    public void verifyInputLinkIsFunctional(){
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        System.out.println("The page contains" + linkElements.size() + "links");
        WebElement inputLink = driver.findElement(By.linkText("Inputs"));
        String inputLinkText = inputLink.getText();
        inputLink.click();
        String headerText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(inputLinkText.equalsIgnoreCase(headerText));
    }
}
