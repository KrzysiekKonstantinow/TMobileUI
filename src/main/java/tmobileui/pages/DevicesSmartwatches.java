package tmobileui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DevicesSmartwatches {

    public SelenideElement firstElement() {
        return $(By.cssSelector("[data-qa='LST_ProductCard0'] a"));
    }

    public SelenideElement firstElementName() {
        return $(By.xpath("//div[@data-qa='LST_ProductCard0']/section/div[2]/h2/span[1]"));
    }
}
