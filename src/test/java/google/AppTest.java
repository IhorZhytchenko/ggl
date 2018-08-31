package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private GooglePage page;

    @BeforeClass
    public void setUp() {
        this.webDriver = new FirefoxDriver();
        this.wait = new WebDriverWait(webDriver, 10, 500);
        this.webDriver.get("https://www.google.com/");
        this.page = new GooglePage(this.webDriver);
    }


    @Test()
    private void test() throws InterruptedException {
        this.page.search("java");
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("res")));
        Assert.assertTrue(this.webDriver.findElements(By.cssSelector("div.g")).size() > 0);
    }

    @AfterClass
    public void down() {
        if(this.webDriver != null) {
            this.webDriver.quit();
        }
    }

}