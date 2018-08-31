package google.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.cart-i-title > a[name=\"goods-link\"]")
    private WebElement phoneTitle;

    @FindBy(name = "close")
    private WebElement continueButton;

    @FindBy(css = "img.cart-check-icon.sprite")
    private WebElement clearCartImg;

    @FindBy(css = "img.popup-close-icon")
    private WebElement closeCartImg;

    @FindBy(name = "delete")
    private WebElement clearCartLink;

    @FindBy(css = "h2.empty-cart-title")
    private WebElement emptyCartText;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20, 500);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getPhoneTitle() {
        return this.phoneTitle;
    }

    public void continueBuy() {
        this.continueButton.click();
    }

    public void clearCart() {
        this.clearCartImg.click();
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("delete")));
        this.clearCartLink.click();
    }

    public WebElement getEmptyCartText() {
        return this.emptyCartText;
    }

    public void closeCart() {
        this.closeCartImg.click();
    }
}
