package tmobileui.stepdef;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import tmobileui.pages.HomePage;
import tmobileui.pages.BasketPage;
import tmobileui.pages.ProductPage;
import tmobileui.pages.DevicesSmartwatches;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class choosePhoneFromTheListFeature {

    private static Logger log = Logger.getLogger(choosePhoneFromTheListFeature.class);
    HomePage homePage = new HomePage();
    DevicesSmartwatches devicesSmartwatches = new DevicesSmartwatches();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();
    public String firstElementName;
    public String[] values;

    @Given("Go to the TMobile page")
    public void go_to_the_tmobile_page() {
        try {
            homePage.open();
            Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), Configuration.baseUrl);
            log.info("T-Mobile landing page opened.");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }

    @And("Choose devices from the top bar")
    public void choose_devices_from_the_top_bar() {
        try {
            homePage.cookiesBarAcceptButton().click();
            homePage.devicesDropdown().click();
            $$(By.cssSelector(".hidden.menu-dropdown-submenu")).first().shouldBe(visible);
            log.info("Devices manu is visible.");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }

    @And("Choose no subscription from the smartwatches and bands")
    public void choose_no_subscription_from_the_smartwatches_and_bands() {
        try {
            homePage.smartwatchesNoSubscriptionButton().click();
            log.info("Smartwatches and bands chosen.");
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }

    @And("Click the first product on the list")
    public void click_the_first_product_one_the_list() {
        try{
            $$(By.className("grid-child")).first().should(exist);
            firstElementName = devicesSmartwatches.firstElementName().getText();
            devicesSmartwatches.firstElement().click();
            log.info("First product chosen.");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }

    @And("Add the product to the cart")
    public void add_the_product_to_the_cart() throws InterruptedException{
        try {
            $(By.cssSelector("[data-qa='PRD_ProductName']")).shouldHave(exactText(firstElementName));
            Thread.sleep(2000);
            values = productPage.values();;
            productPage.addToBasketButton().click();
            log.info("Product added to basket.");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }

    }

    @When("Go to the main TMobile page")
    public void go_to_the_main_tmobile_page() {
        try {
            $(By.className("basketHeaderText")).should(exist);
            $(By.cssSelector("[data-qa='BKT_TotalupFront']")).shouldHave(exactText(values[0]));
            $(By.cssSelector("[data-qa='BKT_TotalMonthly']")).shouldHave(exactText(values[1]));
            basketPage.logoTMobile().click();
            log.info("Basket page opened, values are displayed as expected.");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }

    @Then("Main page is visible")
    public void main_page_is_visible() {
        try{
            Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), Configuration.baseUrl);
            $(By.xpath("(//a[@data-ma='menu-basket']/div[contains(text(), \"1\")])[1]")).shouldBe(visible);
            log.info("Landing page opened.");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }

    @And("There should be one element in the basket")
    public void there_should_be_one_element_in_the_basket() {
        try{
            $(By.xpath("(//a[@data-ma='menu-basket']/div[contains(text(), \"1\")])[1]")).shouldBe(visible);
            log.info("Basket consists of one product. Test ended successfully");
        }
        catch(AssertionError ae){
            log.info("Test ended with assertion error: " + ae.getMessage());
            Assert.fail();
        }
        catch(Exception e){
            log.info("Test ended with error: " + e.getMessage());
            Assert.fail();
        }
    }
}
