package testSuites;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.creditPages.CreditPage;
import pages.creditPages.CreditUnderDepositPage;
import pages.creditPages.PaymentSchedulePage;
import pages.homePage.HomePage;
import steps.CreditInputData;
import steps.MapAssertions;
import utils.PreparationUtils;

import java.io.IOException;
import java.util.Map;

@Epic("Web tests")
@Feature("MTS bank website")
@DisplayName("Тестовый набор сценариев для категории «Кредиты»")
@Link(name = "Ссылка на сайт", url = "https://www.mtsbank.ru/")
@Owner("Дребезова Наталья")
public class CreditTests extends BaseTests {
    HomePage homePage = new HomePage();
    CreditPage creditPage = new CreditPage();
    CreditUnderDepositPage creditUnderDepositPage = new CreditUnderDepositPage();
    PaymentSchedulePage paymentSchedulePage = new PaymentSchedulePage();
    CreditInputData creditInputData;

    @Test
    @Feature("Десктопная версия сайта")
    @DisplayName("Проверка совпадения параметров кредита на двух страницах")
    @Description("Проверяем совпадение параметров («Ежемесячный платеж» , «Ставка»  и «Сумма кредита») " +
            "кредита на странице его расчета и на странице графика платежей")
    @Severity(SeverityLevel.MINOR)
    public void creditTest() throws IOException {
        creditInputData = mapper.readValue(fileForCredit, CreditInputData.class);
        homePage.openHomePage()
                .clickCreditCategory();
        creditPage.clickCreditUnderDepositPoster(creditInputData.getPosterName());
        creditUnderDepositPage.clickSubmitApplication()
                .fullCreditSumField(creditInputData.getCreditSum().get(PreparationUtils.getRandomIntegerBetweenRange(0, 6)))
                .fullCreditPeriodField(creditInputData.getCreditPeriod().get(PreparationUtils.getRandomIntegerBetweenRange(0, 6)))
                .selectTypeIncomeField(creditInputData.getTypeOfIncome().get(PreparationUtils.getRandomIntegerBetweenRange(0, 1)))
                .selectObjectDepositField(creditInputData.getObjectName().get(PreparationUtils.getRandomIntegerBetweenRange(0, 2)))
                .fullCityField(creditInputData.getCity().get(PreparationUtils.getRandomIntegerBetweenRange(0, 28)))
                .selectCreditGoalField(creditInputData.getCreditGoal().get(PreparationUtils.getRandomIntegerBetweenRange(0, 9)));
        Map<String, String> creditParamsFromCreditUnderDepositPage = creditUnderDepositPage.getCreditParams();
        creditUnderDepositPage.clickPaymentScheduleButton();
        Map<String, String> creditParamsFromPaymentSchedulePage = paymentSchedulePage.getCreditParams();
        MapAssertions.assertMapEquals(creditParamsFromCreditUnderDepositPage, creditParamsFromPaymentSchedulePage);
    }

    @Test
    @Feature("Мобильная версия сайта")
    @DisplayName("Проверка совпадения параметров кредита на двух страницах")
    @Description("Проверяем совпадение параметров («Ежемесячный платеж» , «Ставка»  и «Сумма кредита») " +
            "кредита на странице его расчета и на странице графика платежей")
    @Severity(SeverityLevel.MINOR)
    public void creditMobileTest() throws IOException {
        creditInputData = mapper.readValue(fileForCredit, CreditInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickCreditIconMobile();
        creditPage.clickCreditUnderDepositPosterMobile(creditInputData.getPosterName());
        creditUnderDepositPage.clickSubmitApplicationMobile()
                .fullCreditSumField(creditInputData.getCreditSum().get(PreparationUtils.getRandomIntegerBetweenRange(0, 6)))
                .fullCreditPeriodField(creditInputData.getCreditPeriod().get(PreparationUtils.getRandomIntegerBetweenRange(0, 6)))
                .selectTypeIncomeField(creditInputData.getTypeOfIncome().get(PreparationUtils.getRandomIntegerBetweenRange(0, 1)))
                .selectObjectDepositField(creditInputData.getObjectName().get(PreparationUtils.getRandomIntegerBetweenRange(0, 2)))
                .fullCityField(creditInputData.getCity().get(PreparationUtils.getRandomIntegerBetweenRange(0, 28)))
                .selectCreditGoalField(creditInputData.getCreditGoal().get(PreparationUtils.getRandomIntegerBetweenRange(0, 9)));
        Map<String, String> creditParamsFromCreditUnderDepositPage = creditUnderDepositPage.getCreditParams();
        creditUnderDepositPage.clickPaymentScheduleButton();
        Map<String, String> creditParamsFromPaymentSchedulePage = paymentSchedulePage.getCreditParams();
        MapAssertions.assertMapEquals(creditParamsFromCreditUnderDepositPage, creditParamsFromPaymentSchedulePage);
    }
}