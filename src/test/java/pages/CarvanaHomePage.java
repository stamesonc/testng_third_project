package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaHomePage extends BasePage{

        public CarvanaHomePage(){super();}

        @FindBy(css = "div[class*='Logo']")
        public WebElement logo;

        @FindBy(css = "div[data-qa='navigation-wrapper']>div>a")
        public List<WebElement> navigationSection;

        @FindBy(css = "div[class*='SignInLink__Des']")
        public WebElement signInButton;

        @FindBy(css = "input[type='email']")
        public WebElement emailInput;

        @FindBy(css = "button[data-testid='Button']")
        public WebElement continueButton;

        @FindBy(css = "input[type='password']")
        public WebElement passwordInput;

        @FindBy(css = "button[data-testid='Button']")
        public WebElement signIn;

        @FindBy(xpath = "//p[text()='Email address and/or password combination is incorrect.']")
        public WebElement errorMessage;

        @FindBy(xpath = "//a[contains(@class,'clLcvu')][1]")
        public WebElement searchButton;
}
