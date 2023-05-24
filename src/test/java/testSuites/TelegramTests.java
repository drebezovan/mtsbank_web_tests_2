package testSuites;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.homePage.HomePage;
import pages.telegramPages.TelegramPage;
import steps.TelegramInputData;

import java.io.IOException;

@Epic("Web tests")
@Feature("MTS bank website")
@DisplayName("Тестовый набор сценариев для категории «Telegram»")
@Link(name = "Ссылка на сайт", url = "https://www.mtsbank.ru/")
@Owner("Дребезова Наталья")
public class TelegramTests extends BaseTests {

    HomePage homePage = new HomePage();
    TelegramPage telegramPage = new TelegramPage();
    TelegramInputData telegramInputData;

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @Feature("Десктопная версия сайта")
    @DisplayName("Проверка совпадения названия Telegram канала с тестовыми данными")
    @Description("Проверяем, что при нажатии на постер «Telegram», на открывшейся странице отображается название, " +
            "совпадающее с тестовыми данными")
    @Severity(SeverityLevel.MINOR)
    public void subscribeTelegramTest(int index) throws IOException {
        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePage()
                .clickSubscribeTelegram();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(index), telegramPage.getNameTelegramGroup());
    }

    @Test
    @Feature("Десктопная версия сайта")
    @DisplayName("Проверка совпадения названия Telegram канала с тестовыми данными при нажатии на иконку мессенджера")
    @Description("Проверяем, что при нажатии на иконку «Telegram», на открывшейся странице отображается название, " +
            "совпадающее с тестовыми данными")
    @Severity(SeverityLevel.MINOR)
    public void telegramButtonTest() throws IOException {
        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePage()
                .clickTelegramButton();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(1), telegramPage.getNameTelegramGroup());
    }

    @Test
    @Feature("Мобильная версия сайта")
    @DisplayName("Проверка совпадения названия Telegram канала с тестовыми данными")
    @Description("Проверяем, что при нажатии на постер «Telegram», на открывшейся странице отображается название, " +
            "совпадающее с тестовыми данными")
    @Severity(SeverityLevel.MINOR)
    public void subscribeTelegramMobileTest() throws IOException {
        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickSubscribeTelegram();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(2), telegramPage.getNameTelegramGroupMobile());
    }

    @Test
    @Feature("Мобильная версия сайта")
    @DisplayName("Проверка совпадения названия Telegram канала с тестовыми данными при нажатии на иконку мессенджера")
    @Description("Проверяем, что при нажатии на иконку «Telegram», на открывшейся странице отображается название, " +
            "совпадающее с тестовыми данными")
    @Severity(SeverityLevel.MINOR)
    public void telegramButtonMobileTest() throws IOException {
        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickTelegramButton();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(1), telegramPage.getNameTelegramGroup());
    }
}