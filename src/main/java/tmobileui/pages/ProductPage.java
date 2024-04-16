package tmobileui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public SelenideElement addToBasketButton() {
        return $(By.xpath("(//button[@data-qa='PRD_AddToBasket'])[2]"));
    }

    public SelenideElement payUpFrontValue(){
        return $(By.xpath("(//div[@data-qa='PRD_TotalUpfront'])[2]/div/div"));
    }

    public SelenideElement subscriptionValue(){
        return $(By.xpath("(//div[@class='sc-gzzPqb jkzHzl dt_typography variant_h4 value'])[4]/div/div"));
    }

    public String[] values(){
        String[] split;
        String[] values = new String[2];
        split = payUpFrontValue().getText().split(" ");
        values[0] = split[0];
        split = subscriptionValue().getText().split(" ");
        values[1] = split[0];
        return values;
    }
}
