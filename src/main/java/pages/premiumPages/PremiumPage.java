package pages.premiumPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PremiumPage {
    public static final By PARTNERS_HEADER = By.cssSelector("div[data-testid='flexbox']>h2");
    public static final By ALL_OFFERS_BUTTON = By.cssSelector("a[href='/chastnim-licam/premium/partners/']");
    public PremiumPage clickAllOffersButton() {
        $(PARTNERS_HEADER).hover();
        $(ALL_OFFERS_BUTTON).click();
        return this;
    }
}