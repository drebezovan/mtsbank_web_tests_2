package pages.premiumPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalWindowPage {

    public static final By MODAL_WINDOW_NAME = By.cssSelector("div.ModalBody-sc-15wbuq5-3.fktovJ>img");

    @Step("На открывшемся модальном окне проверить название постера")
    public String getModalWindowName() {
        return $(MODAL_WINDOW_NAME).getAttribute("alt");
    }
}