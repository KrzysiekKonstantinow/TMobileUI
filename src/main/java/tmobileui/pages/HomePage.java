package tmobileui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public HomePage open(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://www.t-mobile.pl/";
        Selenide.open("");
        WebDriver driver = WebDriverRunner.getWebDriver();
        //driver.manage().window().maximize();
        return this;
    }
    public SelenideElement devicesDropdown() {
        return $(By.xpath("//button[contains(text(),'Urządzenia')]"));
    }

    public SelenideElement cookiesBarAcceptButton() {
        return $(By.id("didomi-notice-agree-button"));
    }

    public SelenideElement smartwatchesNoSubscriptionButton() {
        return $(By.xpath("//li[1]/div/div/ul/li[2]/ul/li[4]/a"));
    }
}
