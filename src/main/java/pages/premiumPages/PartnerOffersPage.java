package pages.premiumPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PartnerOffersPage {

    public static final By PARTNER_OFFERS_CATEGORY = By.cssSelector("div.DesktopWrapper-sc-1cd5b3b-0.gkbVsr>span>div");
    public static final By PARTNER_OFFERS_CATEGORY_MOBILE = By.cssSelector("div.TextWrapper-sc-cb89gg-1.dwzzrZ>div");
    public static final By FIELD_AROUND_SELECTOR = By.cssSelector("div.Inner-sc-1sa4xnu-0.dZcsdJ");
    public static final By SECTION_NAME = By.cssSelector("div>h2");
    public static final String PARTNER_OFFERS_POSTER = "div.DesktopWrapper-sc-1cd5b3b-0.gkbVsr>div>div>div>div>img[alt='%s']";
    public static final String PARTNER_OFFERS_POSTER_MOBILE = "div.MobileWrapper-sc-1w1j3uo-0.ivcTWV>div>div>div>div>div>div>div>div>img[alt='%s']";
    public static final By SELECTOR = By.cssSelector("i[data-testid='icon_baseX24/ic-arrow-down']>svg");

    @Step("На открывшейся странице выбрать раздел (например, «Искусство»)")
    public PartnerOffersPage clickPartnerOffersCategory(String categoryName) {
        $$(PARTNER_OFFERS_CATEGORY).findBy(Condition.text(categoryName)).click();
        $$(SECTION_NAME).findBy(Condition.text(categoryName)).hover();
        return this;
    }

    @Step("Выбрать категорию (например, «Искусство») кликнуть по полю вокруг селектора")
    public PartnerOffersPage clickPartnerOffersCategoryMobile(String categoryName) {
        $$(PARTNER_OFFERS_CATEGORY_MOBILE).findBy(Condition.text(categoryName)).click();
        $(FIELD_AROUND_SELECTOR).click();
        return this;
    }

    @Step("В выбранном разделе нажать на первый постер")
    public PartnerOffersPage clickPartnerOffersPoster(String posterName) {
        $$(String.format(PARTNER_OFFERS_POSTER, posterName))
                .findBy(Condition.attribute("alt", posterName))
                .click();
        return this;
    }

    @Step("В выбранном разделе нажать на любой постер")
    public PartnerOffersPage clickPartnerOffersPosterMobile(String posterName) {
        $$(String.format(PARTNER_OFFERS_POSTER_MOBILE, posterName))
                .findBy(Condition.attribute("alt", posterName))
                .scrollIntoView(true)
                .click();
        return this;
    }

    @Step("Нажать на значок селектора")
    public PartnerOffersPage clickSelector() {
        $(SELECTOR).doubleClick();
        return this;
    }
}