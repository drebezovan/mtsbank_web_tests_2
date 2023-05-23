package testSuites;

import org.junit.jupiter.api.Test;
import pages.creditPages.CreditPage;
import pages.creditPages.CreditUnderDepositPage;
import pages.creditPages.PaymentSchedulePage;
import pages.homePage.HomePage;
import steps.CreditInputData;
import steps.MapAssertions;

import java.io.IOException;
import java.util.Map;

public class CreditTests extends BaseTests{
    HomePage homePage = new HomePage();
    CreditPage creditPage = new CreditPage();
    CreditUnderDepositPage creditUnderDepositPage = new CreditUnderDepositPage();
    PaymentSchedulePage paymentSchedulePage = new PaymentSchedulePage();

    CreditInputData creditInputData;

    @Test
    public void creditTest() throws IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на категорию "Кредиты" в шапке сайта
        // нажать на постер "Кредит под залог"
        // нажать на кнопку "Подать заявку"
        // заполнить все поля в области "Рассчитайте условия по вашему кредиту"
        // сохранить (в переменные) значения полей "Ежемесячный платеж", "Ставка" и "Сумма кредита"
        // нажать на кнопку "Открыть график платежей"
        // на открывшейся странице проверить совпадение полей "Ежемесячный платеж", "Ставка" и "Сумма кредита"

        creditInputData = mapper.readValue(fileForCredit, CreditInputData.class);

        homePage.openHomePage()
                .clickCreditCategory();
        creditPage.clickCreditUnderDepositPoster(creditInputData.getPosterName());
        creditUnderDepositPage.clickSubmitApplication()
                              .fullCreditSumField(creditInputData.getCreditSum().get(2))
                              .fullCreditPeriodField(creditInputData.getCreditPeriod().get(2))
                              .selectTypeIncomeField(creditInputData.getTypeOfIncome().get(1))
                              .selectObjectDepositField(creditInputData.getObjectName().get(2))
                              .fullCityField(creditInputData.getCity())
                              .selectCreditGoalField(creditInputData.getCreditGoal().get(2));
        Map<String, String> creditParamsFromCreditUnderDepositPage = creditUnderDepositPage.getCreditParams();
        creditUnderDepositPage.clickPaymentScheduleButton();
        Map<String, String> creditParamsFromPaymentSchedulePage = paymentSchedulePage.getCreditParams();
        MapAssertions.assertMapEquals(creditParamsFromCreditUnderDepositPage, creditParamsFromPaymentSchedulePage);
    }
    @Test
    public void creditMobileTest() throws IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на иконку "Кредиты" внизу экрана
        // нажать на постер "Кредит под залог"
        // нажать на кнопку "Подать заявку"
        // заполнить все поля в области "Рассчитайте условия по вашему кредиту"
        // сохранить (в переменные) значения полей "Ежемесячный платеж", "Ставка" и "Сумма кредита"
        // нажать на кнопку "Открыть график платежей"
        // на открывшейся странице проверить совпадение полей "Ежемесячный платеж", "Ставка" и "Сумма кредита"

        creditInputData = mapper.readValue(fileForCredit, CreditInputData.class);

        homePage.openHomePageMobile()
                .clickCreditIconMobile();
        creditPage.clickCreditUnderDepositPosterMobile(creditInputData.getPosterName());
        creditUnderDepositPage.clickSubmitApplicationMobile()
                              .fullCreditSumField(creditInputData.getCreditSum().get(2))
                              .fullCreditPeriodField(creditInputData.getCreditPeriod().get(2))
                              .selectTypeIncomeField(creditInputData.getTypeOfIncome().get(1))
                              .selectObjectDepositField(creditInputData.getObjectName().get(2))
                              .fullCityField(creditInputData.getCity())
                              .selectCreditGoalField(creditInputData.getCreditGoal().get(2));
        Map<String, String> creditParamsFromCreditUnderDepositPage = creditUnderDepositPage.getCreditParams();
        creditUnderDepositPage.clickPaymentScheduleButton();
        Map<String, String> creditParamsFromPaymentSchedulePage = paymentSchedulePage.getCreditParams();
        MapAssertions.assertMapEquals(creditParamsFromCreditUnderDepositPage, creditParamsFromPaymentSchedulePage);
    }
}