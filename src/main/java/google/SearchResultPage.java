package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;

    @FindBy(css = "div.rc h3.r a")
    private List<WebElement> titles;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getResultTitles() {
        return this.titles;
    }
}
