package testSuites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.homePage.HomePage;
import pages.smallBusinessPages.CheckingAccountPage;
import pages.smallBusinessPages.ChooseTariffPage;
import pages.smallBusinessPages.SmallBusinessPage;
import steps.BusinessInputData;

import java.io.IOException;

import static utils.PreparationUtils.getRandomIntegerBetweenRange;

public class SmallBusinessTests extends BaseTests{
    HomePage homePage = new HomePage();
    SmallBusinessPage smallBusinessPage = new SmallBusinessPage();
    CheckingAccountPage checkingAccountPage = new CheckingAccountPage();
    ChooseTariffPage chooseTariffPage = new ChooseTariffPage();
    BusinessInputData businessInputData;
    int randomNum = getRandomIntegerBetweenRange(-1, 10000001);
    @Test
    public void smallBusinessTest() throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на категорию "Малый бизнес и ИП" в шапке сайта
        // нажать на категорию "Расчетный счет"
        // нажать на кнопку "Открыть счет" на постере "Открыть расчетный счет"
        // нажать на кнопку "Подобрать тариф"
        // заполнить все поля в области "Подберите тариф для бизнеса"
        // навести на рекомендованный тариф и сохранить его название (в переменную)
        // нажать на кнопку "Открыть счет" рекомендованного тарифа
        // проверить название тарифа

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
        System.out.println(chooseTariffPage.getNameOfRecommendedTariff());
        chooseTariffPage.clickOpenAccountButton();
        System.out.println(chooseTariffPage.getNameOfTariffInApplication());
    }
    @Test
    public void smallBusinessMobileTest() throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на иконку "Ещё" внизу экрана
        // нажать на категорию "Малый бизнес и ИП"
        // в выпадающем списке нажать на категорию "Расчетный счет"
        // нажать на кнопку "Открыть счет" на постере "Открыть расчетный счет"
        // нажать на кнопку "Единоразово" в области "Тарифы для обслуживания счета"
        // навести на рекомендованный тариф
        // нажать на кнопку "Открыть счет" рекомендованного тарифа
        // заполнить все поля, кроме ИНН
        // поставить галочку в "Ввести данные организации вручную"
        // заполнить появившиеся поля
        // нажать на кнопку "Отправить заявку"
        // проверить, что отображается сообщение об ошибке "Поле обязательно для заполнения"

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