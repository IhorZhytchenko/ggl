package google.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonePage {
    private final WebDriver driver;

    @FindBy(css = "h1.detail-title")
    private WebElement detailTitle;

    @FindBy(xpath = "//li/div[2]/div/a")
    private WebElement cartLink;

    @FindBy(name = "topurchases")
    private WebElement buyButton;

    public PhonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void addToCart() {
        this.buyButton.click();
    }

    public WebElement getDetailTitle() {
        return detailTitle;
    }

    public void goToCart() {
        this.cartLink.click();
    }
}
