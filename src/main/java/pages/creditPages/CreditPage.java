package pages.creditPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    public static final By POSTER_NAME = By.xpath
            ("//div[@class='sc-fubCzh idFBpR']/div/div/a/h3 | //div[@class='sc-higWrZ loQCSz']/div/a/h3|" +
                    " //div[@class='sc-jGVbWl hAfCbE']/div/a/h3");
    public static final By POSTER_NAME_MOBILE = By.cssSelector("div.sc-dlfnuX.bquglO>a>h4>div");
    public CreditPage clickCreditUnderDepositPoster(String posterName){
        SelenideElement creditPoster = $$(POSTER_NAME).findBy(Condition.text(posterName));
        creditPoster.shouldBe(Condition.visible).click();
        return this;
    }
    public CreditPage clickCreditUnderDepositPosterMobile(String posterName){
        SelenideElement creditPoster = $$(POSTER_NAME_MOBILE).findBy(Condition.text(posterName));
        creditPoster.shouldBe(Condition.visible).click();
        return this;
    }
}