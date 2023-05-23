package testSuites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.homePage.HomePage;
import pages.telegramPages.TelegramPage;
import steps.TelegramInputData;

import java.io.IOException;

public class TelegramTests extends BaseTests{

    HomePage homePage = new HomePage();
    TelegramPage telegramPage = new TelegramPage();
    TelegramInputData telegramInputData;

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    public void negativeTelegramTest(int index) throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // найти постер "Новости МТС банка без задержки в Telegram"
        // Нажать на кнопку "Подписаться"
        // на открывшейся странице проверить название канала с ожидаемыми названиями

        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePage()
                .clickSubscribeTelegram();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(index),telegramPage.getNameTelegramGroup());
    }
    @Test
    public void positiveTelegramTest() throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // найти в конце страницы иконку с изображением логотипа Telegram
        // нажать на эту иконку
        // на открывшейся странице проверить, что отображается надпись "Новости МТС Банка без задержки"

        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePage()
                .clickTelegramButton();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(1),telegramPage.getNameTelegramGroup());
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    public void negativeTelegramMobileTest(int index) throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // найти постер "Новости МТС банка без задержки в Telegram"
        // Нажать на кнопку "Подписаться"
        // на открывшейся странице проверить название канала с ожидаемыми названиями

        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePageMobile()
                .clickSubscribeTelegram();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(index),telegramPage.getNameTelegramGroup());
    }
    @Test
    public void positiveTelegramMobileTest() throws InterruptedException, IOException {
        // открыть сайт https://www.mtsbank.ru/
        // найти в конце страницы иконку с изображением логотипа Telegram
        // нажать на эту иконку
        // на открывшейся странице проверить, что отображается надпись "Новости МТС Банка без задержки"

        telegramInputData = mapper.readValue(fileForTelegram, TelegramInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickTelegramButton();
        Assertions.assertEquals(telegramInputData.getNameTelegramGroup().get(1),telegramPage.getNameTelegramGroup());
    }
}