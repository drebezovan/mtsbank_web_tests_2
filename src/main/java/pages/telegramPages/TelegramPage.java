package pages.telegramPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {
    public static final By NAME_TELEGRAM_GROUP = By.xpath("//div[@class='tgme_page_description'] | " +
            "//div[@class='tgme_channel_info_description']");
    public static final By NAME_TELEGRAM_GROUP_MOBILE = By.xpath("//div[@class='tgme_header_title']//span");

    @Step("На открывшейся странице проверить название канала с ожидаемыми названиями")
    public String getNameTelegramGroup() {
        return $(NAME_TELEGRAM_GROUP).getText().split("\n")[0];
    }

    @Step("На открывшейся странице проверить название канала с ожидаемым названием")
    public String getNameTelegramGroupMobile() {
        return $(NAME_TELEGRAM_GROUP_MOBILE).getText();
    }
}