package pages.creditPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import steps.PageWithCreditParameters;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditUnderDepositPage implements PageWithCreditParameters {

    public static final By SUBMIT_APPLICATION_BUTTON = By.xpath
            ("//div[@class='styled__Wrapper-sc-44ximf-1 iHeHnU']/div/div/button");
    public static final By SUBMIT_APPLICATION_BUTTON_MOBILE = By.cssSelector
            ("div.styled__Wrapper-sc-1alu4l7-1.bppgPy>div>button");
    public static final By CREDIT_SUM = By.cssSelector("div[label='Сумма кредита']>input");
    public static final By CREDIT_PERIOD = By.cssSelector("div[label='Срок кредита']>input");
    public static final By SELECT_TYPES_INCOME = By.cssSelector("div[label='Укажите основной вид дохода']>input");
    public static final By SELECT_FIELDS = By.cssSelector("div.ScrollContainer-sc-hd8eza-0.gNecSV>div>div");
    public static final By SELECT_OBJECTS_DEPOSIT = By.cssSelector("div[label='Объект залога']>input");
    public static final By CITY_FIELD = By.cssSelector("div[label='Город объекта залога']>input");
    public static final By FIRST_CITY_FIELD = By.cssSelector("ul[role='listbox']>li");
    public static final By CREDIT_GOAL_FIELD = By.cssSelector("div[label='Цель кредита']>input");
    public static final By NAME_PARAMETER_FIELD = By.xpath
            ("//div[@class='sc-crrszt iprLEn']//div | //div[@class='sc-citxvW hZzfEK']//div");
    public static final By VALUE_PARAMETER_FIELD = By.xpath(".//..//..//h4");
    public static final By PAYMENT_SCHEDULE_BUTTON = By.xpath("//div[@class='sc-iJuVqt hSZvIe']//button");

    @Step("Нажать на кнопку «Подать заявку»")
    public CreditUnderDepositPage clickSubmitApplication() {
        $(SUBMIT_APPLICATION_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку «Подать заявку»")
    public CreditUnderDepositPage clickSubmitApplicationMobile() {
        $(SUBMIT_APPLICATION_BUTTON_MOBILE).click();
        return this;
    }

    @Step("Заполнить все поля в области «Рассчитайте условия по вашему кредиту» (сумму кредита)")
    public CreditUnderDepositPage fullCreditSumField(String creditSum) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        $(CREDIT_SUM).sendKeys(del + creditSum);
        return this;
    }

    @Step("Заполнить все поля в области «Рассчитайте условия по вашему кредиту» (срок кредита)")
    public CreditUnderDepositPage fullCreditPeriodField(String creditPeriod) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        $(CREDIT_PERIOD).sendKeys(del + creditPeriod);
        return this;
    }

    @Step("Заполнить все поля в области «Рассчитайте условия по вашему кредиту» (основной вид дохода)")
    public CreditUnderDepositPage selectTypeIncomeField(String incomeName) {
        $(SELECT_TYPES_INCOME).click();
        $$(SELECT_FIELDS).findBy(Condition.text(incomeName)).click();
        return this;
    }

    @Step("Заполнить все поля в области «Рассчитайте условия по вашему кредиту» (объект залога)")
    public CreditUnderDepositPage selectObjectDepositField(String objectName) {
        $(SELECT_OBJECTS_DEPOSIT).click();
        $$(SELECT_FIELDS).findBy(Condition.text(objectName)).click();
        return this;
    }

    @Step("Заполнить все поля в области «Рассчитайте условия по вашему кредиту» (город объекта залога)")
    public CreditUnderDepositPage fullCityField(String city) {
        $(CITY_FIELD).sendKeys(city);
        $(FIRST_CITY_FIELD).click();
        return this;
    }

    @Step("Заполнить все поля в области «Рассчитайте условия по вашему кредиту» (цель кредита)")
    public CreditUnderDepositPage selectCreditGoalField(String objectName) {
        $(CREDIT_GOAL_FIELD).click();
        $$(SELECT_FIELDS).findBy(Condition.text(objectName)).click();
        return this;
    }

    @Step("Сохранить (в переменные) значения полей «Ежемесячный платеж» , «Ставка»  и «Сумма кредита»")
    public String getParameter(String nameOfParameter) {
        return $$(NAME_PARAMETER_FIELD).findBy(Condition.text(nameOfParameter)).$(VALUE_PARAMETER_FIELD).getText().trim();
    }

    @Step("Нажать на кнопку «Открыть график платежей»")
    public CreditUnderDepositPage clickPaymentScheduleButton() {
        $(PAYMENT_SCHEDULE_BUTTON).click();
        return this;
    }
}