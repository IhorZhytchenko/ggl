package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest {
    private static final String Q = "Java";
    private WebDriver webDriver;
    private WebDriverWait wait;
    private GooglePage page;
    private SearchResultPage resultPage;

    @BeforeClass
    public void setUp() {
        this.webDriver = new FirefoxDriver();
        this.wait = new WebDriverWait(webDriver, 10, 500);
        this.webDriver.get("https://www.google.com/");
        this.page = new GooglePage(this.webDriver);
        this.resultPage = new SearchResultPage(this.webDriver);
        this.page.search(Q);
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("res")));

    }


    @Test()
    private void test() {
        Assert.assertTrue(this.resultPage.getResultTitles().size() > 0);
    }

    @Test()
    private void titleTest()  {
        for (WebElement element: this.resultPage.getResultTitles()) {
            Assert.assertTrue(element.getText().contains(Q));
        }
    }

    @AfterClass
    public void down() {
        if(this.webDriver != null) {
            this.webDriver.quit();
        }
    }

}