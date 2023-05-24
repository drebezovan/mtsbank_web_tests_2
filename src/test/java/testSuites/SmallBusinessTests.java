package testSuites;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.homePage.HomePage;
import pages.smallBusinessPages.CheckingAccountPage;
import pages.smallBusinessPages.ChooseTariffPage;
import pages.smallBusinessPages.SmallBusinessPage;
import steps.BusinessInputData;

import java.io.IOException;

import static utils.PreparationUtils.getRandomIntegerBetweenRange;

@Epic("Web tests")
@Feature("MTS bank website")
@DisplayName("Тестовый набор сценариев для категории «Малый бизнес и ИП»")
@Link(name = "Ссылка на сайт", url = "https://www.mtsbank.ru/")
@Owner("Дребезова Наталья")
public class SmallBusinessTests extends BaseTests {
    HomePage homePage = new HomePage();
    SmallBusinessPage smallBusinessPage = new SmallBusinessPage();
    CheckingAccountPage checkingAccountPage = new CheckingAccountPage();
    ChooseTariffPage chooseTariffPage = new ChooseTariffPage();
    BusinessInputData businessInputData;

    @Test
    @Feature("Десктопная версия сайта")
    @DisplayName("Проверка отображения выбранного тарифа при заполнении заявки на открытие счета")
    @Description("Проверяем, что при подборе рекомендованного тарифа, его название совпадает с названием, " +
            "которое отображается при заполнении заявки на открытие счета")
    @Severity(SeverityLevel.NORMAL)
    public void smallBusinessTest() throws IOException {
        businessInputData = mapper.readValue(fileForBusiness, BusinessInputData.class);
        homePage.openHomePage()
                .clickSmallBusinessCategory();
        smallBusinessPage.clickCheckingAccountCategory();
        checkingAccountPage.clickOpenAccountButton()
                .clickChooseTariffButton();
        chooseTariffPage.fullPlaceholder(businessInputData.getPlaceholderName().get(0), getRandomIntegerBetweenRange(-1, 1001))
                .fullPlaceholder(businessInputData.getPlaceholderName().get(1), getRandomIntegerBetweenRange(-1, 10000001))
                .fullPlaceholder(businessInputData.getPlaceholderName().get(2), getRandomIntegerBetweenRange(-1, 10000001))
                .fullPlaceholder(businessInputData.getPlaceholderName().get(3), getRandomIntegerBetweenRange(-1, 5000001))
                .fullPlaceholder(businessInputData.getPlaceholderName().get(4), getRandomIntegerBetweenRange(-1, 10000001));
        String recommendedTariff = chooseTariffPage.getNameOfRecommendedTariff();
        chooseTariffPage.clickOpenAccountButton();
        Assertions.assertEquals(recommendedTariff, chooseTariffPage.getNameOfTariffInApplication());
    }

    @Test
    @Feature("Мобильная версия сайта")
    @DisplayName("Проверка отображения сообщения об ошибке при заполнении заявки на открытие счета")
    @Description("Проверяем, что при заполнении заявки на рекомендованный тариф, отображается сообщение об ошибке " +
            "при некорректном введении почты в поле")
    @Severity(SeverityLevel.CRITICAL)
    public void smallBusinessMobileTest() throws IOException {
        businessInputData = mapper.readValue(fileForBusiness, BusinessInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickCategoriesIcon()
                .clickCategoryMobile(businessInputData.getCategoryName())
                .clickSmallBusinessCategoryMobile();
        checkingAccountPage.clickOpenAccountButtonMobile()
                .clickPaymentTypeTariffMobile()
                .clickBestTariffMobile()
                .fullFields(businessInputData.getTelephone(), businessInputData.getEmail())
                .clickCheckbox()
                .fullFieldsForOrganization(businessInputData.getOrganizationName(),
                        businessInputData.getNameOfSelectorField().get(1), businessInputData.getFullName());
        Assertions.assertEquals(businessInputData.getErrorMsg(), checkingAccountPage.getErrorMsg());
    }
}