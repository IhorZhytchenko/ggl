package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    private final WebDriver driver;

    @FindBy(id = "lst-ib")
    WebElement input;

    @FindBy(name = "btnK")
    WebElement button;



    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void search(String q) {
        this.input.sendKeys(q);
        this.button.click();
    }
}
