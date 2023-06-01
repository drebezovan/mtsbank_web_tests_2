package pages.creditPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    public static final By POSTER_NAME = By.xpath("//a//h3 ");
    public static final By POSTER_NAME_MOBILE = By.xpath
            ("//h4//div");

    @Step("Нажать на постер «Кредит под залог»")
    public CreditPage clickCreditUnderDepositPoster(String posterName) {
        $$(POSTER_NAME).findBy(Condition.text(posterName)).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Нажать на постер «Кредит под залог»")
    public CreditPage clickCreditUnderDepositPosterMobile(String posterName) {
        $$(POSTER_NAME_MOBILE).findBy(Condition.text(posterName)).shouldBe(Condition.visible).click();
        return this;
    }
}