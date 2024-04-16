package tmobileui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    public SelenideElement logoTMobile(){
        return $(By.className("logo-img-wrap"));
    }
}
