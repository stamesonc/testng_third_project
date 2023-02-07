package scripts;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarPage;
import utils.ConfigReader;
import utils.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarvanaTest extends BasePageTest{
    @BeforeMethod
    public void setPage() {
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchCarPage = new CarvanaSearchCarPage();
    }

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndUrl() {
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }
    @Test(priority = 2, description = " Validate the Carvana logo")
    public void validateLogo() {
        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateNavigationItems() {
        String[] items = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < items.length; i++) {
            Assert.assertEquals(carvanaHomePage.navigationSection.get(i).getText(), items[i]);
            Assert.assertTrue(carvanaHomePage.navigationSection.get(i).isDisplayed());
        }
    }
    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInErrorMessage() {
        carvanaHomePage.signInButton.click();
        Waiter.pause(5);
        carvanaHomePage.emailInput.sendKeys(" johndoe@gmail.com");
        carvanaHomePage.continueButton.click();
        carvanaHomePage.passwordInput.sendKeys("abcd1234");
        carvanaHomePage.signIn.click();
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect.");
    }
    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateFilterOptions() {
        String[] filterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        carvanaHomePage.searchButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        for (int i = 0; i < filterOptions.length; i++) {
            Assert.assertEquals(carvanaSearchCarPage.filterOptions.get(i).getText(), filterOptions[i]);
            Assert.assertTrue(carvanaSearchCarPage.filterOptions.get(i).isDisplayed());
        }
    }
    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateSearchResults() {
        carvanaHomePage.searchButton.click();
        carvanaSearchCarPage.searchBox.sendKeys(ConfigReader.getProp("searchCar"));
        carvanaSearchCarPage.goButton.click();
        Waiter.pause(8);
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProp("searchCar")));

        List<WebElement> allItems = new ArrayList<>(carvanaSearchCarPage.images);
        allItems.addAll(carvanaSearchCarPage.favoriteIcon);
        allItems.addAll(carvanaSearchCarPage.price);
        allItems.addAll(carvanaSearchCarPage.results);

        while(carvanaSearchCarPage.nextButton.isEnabled()){
            for (int i = 0; i < carvanaSearchCarPage.price.size(); i++) {
                Assert.assertNotNull(carvanaSearchCarPage.images.get(i));
                Assert.assertNotNull(carvanaSearchCarPage.favoriteIcon.get(i));
                Assert.assertNotNull(carvanaSearchCarPage.price.get(i));
                Assert.assertTrue(Integer.parseInt(carvanaSearchCarPage.price.get(i).getText().substring(1).replaceAll(",", "")) > 0);
                Assert.assertNotNull(carvanaSearchCarPage.results.get(i));
                Objects.requireNonNull(carvanaSearchCarPage.results.get(i).getText());

            }
            carvanaSearchCarPage.nextButton.click();
        }
    }
}
