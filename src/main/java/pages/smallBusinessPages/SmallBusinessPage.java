package pages.smallBusinessPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SmallBusinessPage {

    public static final By CHECKING_ACCOUNT_CATEGORY = By.cssSelector("a[href='/malomu-biznesu/raschetny-schet/']>div.sc-fubCzh.hPIPGu");

    @Step("Нажать на категорию «Расчетный счет»")
    public SmallBusinessPage clickCheckingAccountCategory() {
        $(CHECKING_ACCOUNT_CATEGORY).click();
        return this;
    }
}