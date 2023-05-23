package pages.telegramPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {
    public static final By NAME_TELEGRAM_GROUP = By.xpath("//div[@class='tgme_page_description'] | " +
            "//div[@class='tgme_channel_info_description']");

    public String getNameTelegramGroup() {
         return $(NAME_TELEGRAM_GROUP).getText().split("\n")[0];
    }
}