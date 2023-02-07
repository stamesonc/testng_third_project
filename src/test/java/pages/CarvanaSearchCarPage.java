package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchCarPage extends BasePage{
    public CarvanaSearchCarPage(){
        super();
    }

    @FindBy(css = "div[data-qa='menu-flex']>button>span")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(xpath = "//div[@class='result-tile']")
    public List<WebElement> results;

    @FindBy(xpath = "//div[@class='result-tile']//picture")
    public List<WebElement> images;

    @FindBy(css = ".favorite-icon")
    public List<WebElement> favoriteIcon;

    @FindBy(css = "div[data-testid='price']")
    public List<WebElement> price;

    @FindBy(css = "svg[data-qa='arrow-forward']")
    public WebElement nextButton;
}
