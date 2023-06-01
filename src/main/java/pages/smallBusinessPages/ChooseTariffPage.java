package pages.smallBusinessPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class ChooseTariffPage {

    public static final String PLACEHOLDER = "div[label='%s']>input";
    public static final By NAME_OF_RECOMMENDED_TARIFF = By.xpath
            ("//div[@class='styled__SmartText-n9vm43-0 hQtTs']");
    public static final By OPEN_ACCOUNT_BUTTON = By.xpath
            ("//div[@class='Inner-sc-1rfqasg-0 jmXqMq HiderWrapper-sc-1kc8xvg-0 dITjhB']//button");
    public static final By NAME_OF_TARIFF_IN_APPLICATION = By.xpath("//div[@label='Тариф']//input");


    @Step("Заполнить все поля в области «Подберите тариф для бизнеса»")
    public ChooseTariffPage fullPlaceholder(String placeholderName, Integer placeholderValue) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        $(String.format(PLACEHOLDER, placeholderName)).sendKeys(del + placeholderValue);
        return this;
    }

    @Step("Навести на рекомендованный тариф и сохранить его название (в переменную)")
    public String getNameOfRecommendedTariff() {
        return $(NAME_OF_RECOMMENDED_TARIFF).getText();
    }

    @Step("Нажать на кнопку «Открыть счет» рекомендованного тарифа")
    public ChooseTariffPage clickOpenAccountButton() {
        $(OPEN_ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Проверить название тарифа")
    public String getNameOfTariffInApplication() {
        return $(NAME_OF_TARIFF_IN_APPLICATION).getAttribute("value");
    }
}