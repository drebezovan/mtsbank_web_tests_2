package pages.creditPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import steps.PageWithCreditParameters;

import static com.codeborne.selenide.Selenide.$$;

public class PaymentSchedulePage implements PageWithCreditParameters {
    public static final By NAME_PARAMETER_FIELD = By.xpath("//div[@class='sc-gyUflj gtGQuS']//div//div//div//div");
    public static final By VALUE_PARAMETER_FIELD = By.xpath(".//..//..//h4");

    @Step("на открывшейся странице проверить совпадение полей «Ежемесячный платеж» , «Ставка»  и «Сумма кредита»")
    public String getParameter(String nameOfParameter) {
        return $$(NAME_PARAMETER_FIELD).findBy(Condition.text(nameOfParameter)).$(VALUE_PARAMETER_FIELD).getText().trim();
    }
}