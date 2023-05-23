package pages.smallBusinessPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChooseTariffPage {

    public static final String PLACEHOLDER = "div[label='%s']>input";
    public static final By NAME_OF_RECOMMENDED_TARIFF = By.xpath
            ("//div[@class='sc-bPjxgn eJGOCe']//div[@class='sc-hrtyTY cYOeVV']//div");
    public static final By OPEN_ACCOUNT_BUTTON = By.xpath("//div[@class='sc-hrtyTY cYOeVV']//div//button");
    public static final By NAME_OF_TARIFF_IN_APPLICATION = By.xpath
            ("//div[@label='Тариф']//input");


    public ChooseTariffPage fullPlaceholder(String placeholderName, Integer placeholderValue){
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        $(String.format(PLACEHOLDER,placeholderName)).sendKeys(del + placeholderValue);
        return this;
    }
    public String getNameOfRecommendedTariff(){
        return $(NAME_OF_RECOMMENDED_TARIFF).getText();
    }
    public ChooseTariffPage clickOpenAccountButton(){
        $(OPEN_ACCOUNT_BUTTON).click();
        return this;
    }
    public String getNameOfTariffInApplication(){
        return $(NAME_OF_TARIFF_IN_APPLICATION).getAttribute("value");
    }
}
