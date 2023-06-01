package pages.homePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public static final ProjectConfig cnf = ConfigFactory.create(ProjectConfig.class);
    public static final By TELEGRAM_SUBSCRIBE_BUTTON = By.cssSelector("a[href='https://t.me/s/mts_bank_official']");
    public static final By TELEGRAM_BUTTON = By.xpath("//a[@href='https://t.me/mts_bank_official']");
    public static final By BLOG_POSTER = By.xpath("//a[@aria-label='Блог']");
    public static final By BLOG_BUTTON_MOBILE = By.xpath
            ("//div[@class='sc-bdfBQB gQaxRr']//div//a//div//div//div");
    public static final By CREDIT_CATEGORY = By.cssSelector("a[href='/chastnim-licam/krediti/']>div.sc-jJEKmz.ejANpH");
    public static final By CREDIT_ICON_MOBILE = By.xpath
            ("//div[@class='sc-fTACoA vzbyM' or @class='sc-btdhtl cduirw']//a[@href='/chastnim-licam/krediti/']");
    public static final By PREMIUM_CATEGORY = By.cssSelector
            ("a[href='/chastnim-licam/private-banking/premium-package/']>div.sc-jJEKmz.ejANpH");
    public static final By SMALL_BUSINESS_CATEGORY = By.cssSelector("a[href='/malomu-biznesu/']");
    public static final By CATEGORIES_ICON_MOBILE = By.xpath("//button//span");
    public static final By PREMIUM_CATEGORY_MOBILE = By.xpath("//div[@class='ReactCollapse--content']//a");
    public static final By CATEGORY_MOBILE = By.cssSelector("div.AccordionButton-sc-zhf5t7-4.fEJcQr>div");
    public static final By SMALL_BUSINESS_CATEGORY_MOBILE = By.cssSelector("div>a[href='/malomu-biznesu/raschetny-schet/']");
    public static final By REGION_FIELD = By.cssSelector("div.sc-XhUvE.kXRvgz>button");


    @Step("Зайти на сайт https://www.mtsbank.ru/")
    public HomePage openHomePage() {
        System.setProperty("chromeoptions.mobileEmulation", "");
        Selenide.open(cnf.baseUrl());
        Selenide.Wait().until(WebDriver::getTitle);
        return this;
    }

    @Step("Зайти на сайт https://www.mtsbank.ru/")
    public HomePage openHomePageMobile() {
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Samsung Galaxy S8+");
        Selenide.open(cnf.baseUrl());
        Selenide.Wait().until(WebDriver::getTitle);
        return this;
    }

    @Step("Принять всплывающее окно о регионе")
    public HomePage clickRegionField() {
        $(REGION_FIELD).click();
        return this;
    }

    @Step("Найти постер «Новости МТС банка без задержки в Telegram» и нажать на кнопку «Подписаться»")
    public HomePage clickSubscribeTelegram() {
        $(TELEGRAM_SUBSCRIBE_BUTTON).scrollIntoView(true).click();
        switchTo().window(1);
        return this;
    }

    @Step("Найти в конце страницы иконку с изображением логотипа Telegram и нажать на эту иконку")
    public HomePage clickTelegramButton() {
        $(TELEGRAM_BUTTON).scrollIntoView(true).click();
        switchTo().window(1);
        return this;
    }

    @Step("Нажать на постер «Блог»")
    public HomePage clickBlogPoster() {
        $(BLOG_POSTER).click();
        switchTo().window(1);
        return this;
    }

    @Step("Нажать на постер «Блог»")
    public HomePage clickBlogPosterMobile(String nameOfPoster) {
        $$(BLOG_BUTTON_MOBILE).findBy(Condition.text(nameOfPoster)).scrollIntoView(true).click();
        return this;
    }

    @Step("Нажать на категорию «Кредиты» в шапке сайта")
    public HomePage clickCreditCategory() {
        $(CREDIT_CATEGORY).click();
        return this;
    }

    @Step("Нажать на иконку «Кредиты» внизу экрана")
    public HomePage clickCreditIconMobile() {
        $(CREDIT_ICON_MOBILE).click();
        return this;
    }

    @Step("Нажать на категорию «Премиум»")
    public HomePage clickPremiumCategory() {
        $(PREMIUM_CATEGORY).click();
        return this;
    }

    @Step("Нажать на категорию «Малый бизнес и ИП» в шапке сайта")
    public HomePage clickSmallBusinessCategory() {
        $(SMALL_BUSINESS_CATEGORY).click();
        return this;
    }

    @Step("Нажать на иконку «Ещё» внизу экрана")
    public HomePage clickCategoriesIcon() {
        $(CATEGORIES_ICON_MOBILE).click();
        return this;
    }

    @Step("Нажать на категорию «Премиум»")
    public HomePage clickPremiumCategoryMobile(String categoryName) {
        $$(PREMIUM_CATEGORY_MOBILE).findBy(Condition.text(categoryName)).click();
        return this;
    }

    @Step("Нажать на категорию «Малый бизнес и ИП»")
    public HomePage clickCategoryMobile(String categoryName) {
        $$(CATEGORY_MOBILE).findBy(Condition.text(categoryName)).click();
        return this;
    }

    @Step("В выпадающем списке нажать на категорию «Расчетный счет»")
    public HomePage clickSmallBusinessCategoryMobile() {
        $(SMALL_BUSINESS_CATEGORY_MOBILE).click();
        return this;
    }
}