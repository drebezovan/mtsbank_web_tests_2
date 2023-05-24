package pages.premiumPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PremiumPage {
    public static final By PARTNERS_HEADER = By.cssSelector("div[data-testid='flexbox']>h2");
    public static final By ALL_OFFERS_BUTTON = By.cssSelector("a[href='/chastnim-licam/premium/partners/']");

    @Step("На открывшейся странице пролистать вниз до раздела «Партнеры» и перейти в раздел «все» (для мобильной версии)" +
            " или «Все предложения» (для десктопной версии)")
    public PremiumPage clickAllOffersButton() {
        $(PARTNERS_HEADER).scrollIntoView(true).hover();
        $(ALL_OFFERS_BUTTON).scrollIntoView(true).click();
        return this;
    }
}