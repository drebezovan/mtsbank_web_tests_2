package pages.telegramPages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TelegramPage {
    public static final By NAME_TELEGRAM_GROUP = By.xpath("//div[@class='tgme_page_description'] | " +
            "//div[@class='tgme_channel_info_description']");
    public static final By NAME_TELEGRAM_GROUP_MOBILE = By.xpath("//div[@class='tgme_header_title']//span");

    public String getNameTelegramGroup() {
         return $(NAME_TELEGRAM_GROUP).getText().split("\n")[0];
    }
    public String getNameTelegramGroupMobile() {
         return $(NAME_TELEGRAM_GROUP_MOBILE).getText();
    }
}