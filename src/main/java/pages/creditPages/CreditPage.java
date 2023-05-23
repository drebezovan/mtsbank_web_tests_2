package pages.creditPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    public static final By POSTER_NAME = By.xpath("//div//div//div//a//h3 ");
    public static final By POSTER_NAME_MOBILE = By.cssSelector("div.sc-dlfnuX.bquglO>a>h4>div");

    public CreditPage clickCreditUnderDepositPoster(String posterName) {
        $$(POSTER_NAME).findBy(Condition.text(posterName)).shouldBe(Condition.visible).click();
        return this;
    }

    public CreditPage clickCreditUnderDepositPosterMobile(String posterName) {
        $$(POSTER_NAME_MOBILE).findBy(Condition.text(posterName)).shouldBe(Condition.visible).click();
        return this;
    }
}