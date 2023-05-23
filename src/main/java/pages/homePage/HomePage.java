package pages.homePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public static final ProjectConfig cnf = ConfigFactory.create(ProjectConfig.class);
    public static final By TELEGRAM_SUBSCRIBE_BUTTON = By.cssSelector("a[href='https://t.me/+WddziliyPY44NWVi']");
    public static final By TELEGRAM_BUTTON = By.xpath("//a[@href='https://t.me/mts_bank_official']");
    public static final By BLOG_POSTER = By.xpath("//a[@aria-label='Блог']");
    public static final By BLOG_POSTER_MOBILE = By.xpath("//div[@class='sc-lgqlnP hZKtWy']//h2");
    public static final By BLOG_BUTTON_MOBILE = By.xpath(".//..//a");
    public static final By CREDIT_CATEGORY = By.cssSelector("a[href='/chastnim-licam/krediti/']>div.sc-jJEKmz.ejANpH");
    public static final By CREDIT_ICON_MOBILE = By.cssSelector("div.sc-gqdwHF.ikGRIR>a[href='/chastnim-licam/krediti/']");
    public static final By PREMIUM_CATEGORY = By.cssSelector
            ("a[href='/chastnim-licam/private-banking/premium-package/']>div.sc-jJEKmz.ejANpH");
    public static final By SMALL_BUSINESS_CATEGORY = By.cssSelector("a[href='/malomu-biznesu/']");
    public static final By CATEGORIES_ICON_MOBILE = By.xpath
            ("//div[@class='sc-btdhtl cduirw']//button | //div[@class='sc-gqdwHF ikGRIR']//button");
    public static final By PREMIUM_CATEGORY_MOBILE = By.cssSelector
            ("a[href='/chastnim-licam/private-banking/premium-package/']");
    public static final By CATEGORY_MOBILE = By.cssSelector("div.AccordionButton-sc-zhf5t7-4.fEJcQr>div");
    public static final By SMALL_BUSINESS_CATEGORY_MOBILE = By.cssSelector
            ("div>a[href='/malomu-biznesu/raschetny-schet/']");
    public static final By REGION_FIELD = By.cssSelector("div.sc-XhUvE.kXRvgz>button");


    public HomePage openHomePage() {
        Selenide.open(cnf.baseUrl());
        Selenide.Wait().until(WebDriver::getTitle);
        return this;
    }

    public HomePage openHomePageMobile() {
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Samsung Galaxy S8+");
        Selenide.open(cnf.baseUrl());
        Selenide.Wait().until(WebDriver::getTitle);
        return this;
    }

    public HomePage clickRegionField() {
        $(REGION_FIELD).click();
        return this;
    }

    public HomePage clickSubscribeTelegram() {
        $(TELEGRAM_SUBSCRIBE_BUTTON).click();
        switchTo().window(1);
        return this;
    }

    public HomePage clickTelegramButton() {
        $(TELEGRAM_BUTTON).click();
        switchTo().window(1);
        return this;
    }

    public HomePage clickBlogPoster() {
        $(BLOG_POSTER).click();
        switchTo().window(1);
        return this;
    }

    public HomePage clickBlogPosterMobile(String nameOfPoster) {
        $$(BLOG_POSTER_MOBILE).findBy(Condition.text(nameOfPoster)).$(BLOG_BUTTON_MOBILE).click();
        switchTo().window(1);
        return this;
    }

    public HomePage clickCreditCategory() {
        $(CREDIT_CATEGORY).click();
        return this;
    }

    public HomePage clickCreditIconMobile() {
        $(CREDIT_ICON_MOBILE).click();
        return this;
    }

    public HomePage clickPremiumCategory() {
        $(PREMIUM_CATEGORY).click();
        return this;
    }

    public HomePage clickSmallBusinessCategory() {
        $(SMALL_BUSINESS_CATEGORY).click();
        return this;
    }

    public HomePage clickCategoriesIcon() {
        $(CATEGORIES_ICON_MOBILE).click();
        return this;
    }

    public HomePage clickPremiumCategoryMobile() {
        $(PREMIUM_CATEGORY_MOBILE).click();
        return this;
    }

    public HomePage clickCategoryMobile(String categoryName) {
        $$(CATEGORY_MOBILE).findBy(Condition.text(categoryName)).click();
        return this;
    }

    public HomePage clickSmallBusinessCategoryMobile() {
        $(SMALL_BUSINESS_CATEGORY_MOBILE).click();
        return this;
    }
}