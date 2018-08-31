package google.rozetka;

import google.GooglePage;
import google.SearchResultPage;
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

public class RozetkaTest {
    private  String phone;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private PhonePage phonePage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        this.webDriver = new FirefoxDriver();
        this.wait = new WebDriverWait(webDriver, 20, 500);
        this.webDriver.get("https://rozetka.com.ua/47132368/p47132368/");
        this.phonePage = new PhonePage(webDriver);
        this.cartPage = new CartPage(webDriver);
       this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.responsive-img")));
       this.phone = this.phonePage.getDetailTitle().getText();
    }


    @Test()
    private void test1() {
       this.phonePage.addToCart();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("close")));
       Assert.assertTrue(this.cartPage.getPhoneTitle().getText().equals(this.phone));

    }
    @Test(dependsOnMethods={"test1"})
    private void test2() {
        this.cartPage.continueBuy();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li/div[2]/div/a")));
        Assert.assertTrue(this.phonePage.getDetailTitle().getText().equals(this.phone));

    }
    @Test(dependsOnMethods={"test2"})
    private void test3() {
        this.phonePage.goToCart();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("close")));
        Assert.assertTrue(this.cartPage.getPhoneTitle().getText().equals(this.phone));

    }

    @Test(dependsOnMethods={"test3"})
    private void test4() {
        this.cartPage.clearCart();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h2.empty-cart-title")));
        Assert.assertTrue(this.cartPage.getEmptyCartText().getText().equals("Корзина пуста"));

    }
    @Test(dependsOnMethods={"test4"})
    private void test5() {
        this.cartPage.closeCart();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("breadcrumbs")));
        Assert.assertTrue(this.phonePage.getDetailTitle().getText().equals(this.phone));

    }

    @Test(dependsOnMethods={"test5"})
    private void test6() {
        this.phonePage.goToCart();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h2.empty-cart-title")));
        Assert.assertTrue(this.cartPage.getEmptyCartText().getText().equals("Корзина пуста"));

    }


    @AfterClass
    public void down() {
        if(this.webDriver != null) {
            this.webDriver.quit();
        }
    }
}
