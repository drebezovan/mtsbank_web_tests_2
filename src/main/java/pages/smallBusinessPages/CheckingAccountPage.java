package pages.smallBusinessPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckingAccountPage {

    public static final By OPEN_ACCOUNT_BUTTON = By.cssSelector
            ("div.styled__Wrapper-sc-44ximf-1.iHeHnU>div>div>button");
    public static final By OPEN_ACCOUNT_BUTTON_MOBILE = By.cssSelector
            ("div.styled__Wrapper-sc-1alu4l7-1.bppgPy>div>button");
    public static final By CHOOSE_TARIFF_BUTTON = By.xpath
            ("//div[ @class='sc-bTvSiT fTNXwT']//div//a");
    public static final By PAYMENT_TYPE_TARIFF = By.xpath
            ("//button[@class='sc-bsipwG dVHGrN']//div | //button[@class='sc-eLgNKc cnlxFV']//div");
    public static final By BEST_TARIFF = By.cssSelector("div.sc-clsFYl.bLZfjY>button");
    public static final By TELEPHONE_FIELD = By.cssSelector("div[label='Мобильный телефон']>input");
    public static final By EMAIL_FIELD = By.cssSelector("div[label='Электронная почта']>input");
    public static final By CHECKBOX = By.cssSelector("div.CheckItem-sc-cb89gg-3.bBBzzn");
    public static final By ORGANIZATION_NAME = By.cssSelector("div[label='Название организации']>input");
    public static final By SELECTOR_FIELD = By.cssSelector("div[label='Организационно-правовая форма']");
    public static final By CATEGORIES_OF_SELECTOR_FIELD = By.cssSelector("div.Wrapper-sc-1uyl36s-0.hXNPho>div");
    public static final By FULL_NAME = By.cssSelector("div[label='Контактное лицо']>input");
    public static final By ERROR_MSG = By.cssSelector("div.Wrapper-sc-1vydk7-0.OlnRe.HelperText-sc-jsokzo-0.hByJHf");

    public CheckingAccountPage clickOpenAccountButton() {
        $(OPEN_ACCOUNT_BUTTON).click();
        return this;
    }

    public CheckingAccountPage clickOpenAccountButtonMobile() {
        $(OPEN_ACCOUNT_BUTTON_MOBILE).click();
        return this;
    }

    public CheckingAccountPage clickChooseTariffButton() {
        $(CHOOSE_TARIFF_BUTTON).shouldBe(Condition.visible).click();
        return this;
    }

    public CheckingAccountPage clickPaymentTypeTariffMobile() {
        $(PAYMENT_TYPE_TARIFF).click();
        return this;
    }

    public CheckingAccountPage clickBestTariffMobile() {
        $(BEST_TARIFF).click();
        return this;
    }

    public CheckingAccountPage fullFields(String telephone, String email) {
        $(TELEPHONE_FIELD).sendKeys(telephone);
        $(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public CheckingAccountPage clickCheckbox() {
        $(CHECKBOX).click();
        return this;
    }

    public CheckingAccountPage fullFieldsForOrganization(String organizationName, String nameOfSelectorField, String name) {
        $(ORGANIZATION_NAME).sendKeys(organizationName);
        $(SELECTOR_FIELD).click();
        $$(CATEGORIES_OF_SELECTOR_FIELD).findBy(Condition.text(nameOfSelectorField)).click();
        $(FULL_NAME).sendKeys(name);
        return this;
    }

    public String getErrorMsg() {
        return $(ERROR_MSG).getText();
    }
}