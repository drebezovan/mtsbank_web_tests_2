package testSuites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.homePage.HomePage;
import pages.premiumPages.ModalWindowPage;
import pages.premiumPages.PartnerOffersPage;
import pages.premiumPages.PremiumPage;
import steps.PremiumInputData;

import java.io.IOException;

public class PremiumTests extends BaseTests {
    HomePage homePage = new HomePage();
    PremiumPage premiumPage = new PremiumPage();
    PartnerOffersPage partnerOffersPage = new PartnerOffersPage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();
    PremiumInputData premiumInputData;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void premiumPartnerTest(int index) throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // перейти в раздел "Премиум" в шапке сайта
        // на открывшейся странице пролистать вниз до раздела "Партнеры"
        // перейти в раздел "Все предложения"
        // на открывшейся странице выбрать раздел (например, "Искусство")
        // в выбранном разделе нажать на первый постер
        // на открывшемся модальном окне проверить название постера

        premiumInputData = mapper.readValue(fileForPremium, PremiumInputData.class);

        homePage.openHomePage()
                .clickPremiumCategory();
        premiumPage.clickAllOffersButton();
        partnerOffersPage.clickPartnerOffersCategory(premiumInputData.getCategory().get(index))
                .clickPartnerOffersPoster(premiumInputData.getPosterName().get(index));
        Assertions.assertEquals(premiumInputData.getPosterName().get(index), modalWindowPage.getModalWindowName());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void premiumPartnerMobileTest(int index) throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на иконку "Ещё" внизу экрана
        // нажать на категорию "Премиум"
        // на открывшейся странице пролистать вниз до раздела "Партнеры"
        // перейти в раздел "все"
        // нажать на значок селектора
        // выбрать категорию (например, "Искусство")
        // нажать на значок селектора
        // в выбранном разделе нажать на любой постер
        // на открывшемся модальном окне проверить название постера

        premiumInputData = mapper.readValue(fileForPremium, PremiumInputData.class);

        homePage.openHomePageMobile()
                .clickCategoriesIcon()
                .clickPremiumCategoryMobile();
        premiumPage.clickAllOffersButton();
        partnerOffersPage.clickSelector()
                .clickPartnerOffersCategoryMobile(premiumInputData.getCategory().get(index))
                .clickSelector()
                .hoverPartnerOffersCategoryMobile(premiumInputData.getCategory().get(index))
                .clickPartnerOffersPosterMobile(premiumInputData.getPosterName().get(index));
        Assertions.assertEquals(premiumInputData.getPosterName().get(index), modalWindowPage.getModalWindowName());
    }
}