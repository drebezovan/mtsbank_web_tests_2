package testSuites;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.homePage.HomePage;
import pages.premiumPages.ModalWindowPage;
import pages.premiumPages.PartnerOffersPage;
import pages.premiumPages.PremiumPage;
import steps.PremiumInputData;

import java.io.IOException;

@Epic("Web tests")
@Feature("MTS bank website")
@DisplayName("Тестовый набор сценариев для категории «Премиум»")
@Link(name = "Ссылка на сайт", url = "https://www.mtsbank.ru/")
@Owner("Дребезова Наталья")
public class PremiumTests extends BaseTests {
    HomePage homePage = new HomePage();
    PremiumPage premiumPage = new PremiumPage();
    PartnerOffersPage partnerOffersPage = new PartnerOffersPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();
    PremiumInputData premiumInputData;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Feature("Десктопная версия сайта")
    @DisplayName("Проверка совпадения названия компании-партнера на странице с перечнем компаний и в модальном окне")
    @Description("Проверяем совпадение названия компании на странице с перечнем компаний и в модальном окне")
    @Severity(SeverityLevel.TRIVIAL)
    public void premiumPartnerTest(int index) throws IOException {
        premiumInputData = mapper.readValue(fileForPremium, PremiumInputData.class);
        homePage.openHomePage()
                .clickPremiumCategory();
        premiumPage.clickAllOffersButton();
        partnerOffersPage.clickPartnerOffersCategory(premiumInputData.getCategory().get(index))
                .clickPartnerOffersPoster(premiumInputData.getPosterName().get(index));
        Assertions.assertEquals(premiumInputData.getPosterName().get(index), modalWindowPage.getModalWindowName());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Feature("Мобильная версия сайта")
    @DisplayName("Проверка совпадения названия компании-партнера на странице с перечнем компаний и в модальном окне")
    @Description("Проверяем совпадение названия компании на странице с перечнем компаний и в модальном окне")
    @Severity(SeverityLevel.TRIVIAL)
    public void premiumPartnerMobileTest(int index) throws IOException {
        premiumInputData = mapper.readValue(fileForPremium, PremiumInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickCategoriesIcon()
                .clickPremiumCategoryMobile(premiumInputData.getCategoryName());
        premiumPage.clickAllOffersButton();
        partnerOffersPage.clickSelector()
                .clickPartnerOffersCategoryMobile(premiumInputData.getCategory().get(index))
                .clickPartnerOffersPosterMobile(premiumInputData.getPosterName().get(index));
        Assertions.assertEquals(premiumInputData.getPosterName().get(index), modalWindowPage.getModalWindowName());
    }
}