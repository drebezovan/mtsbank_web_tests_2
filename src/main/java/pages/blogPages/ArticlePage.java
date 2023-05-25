package pages.blogPages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import steps.PageWithArticleParameters;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage implements PageWithArticleParameters {
    public static final By ARTICLE_CATEGORY = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt' or @class='sc-pGacB hqCMbN' or @class='sc-pGacB eFCEke']//div//div//a");
    public static final By ARTICLE_NAME = By.xpath
            ("//div//div//h1 | //div[@class='sc-hKgJUU jaxqmo' or @class='sc-laRQdt eUTSjA']//p");
    public static final By ARTICLE_DATE = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt' or @class='sc-pGacB hqCMbN' or @class='sc-pGacB eFCEke']//div//div//div");
    public static final By ARTICLE_READING_TIME = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt' or @class='sc-pGacB hqCMbN' or @class='sc-pGacB eFCEke']//div//div//div//div");

    @Step("На открывшейся странице проверить совпадение категории")
    public String getArticleCategory() {
        return $(ARTICLE_CATEGORY).shouldBe(Condition.visible).innerText().trim();
    }

    @Step("На открывшейся странице проверить совпадение названия статьи")
    public String getArticleName() {
        return $(ARTICLE_NAME).innerText().trim();
    }

    @Step("На открывшейся странице проверить совпадение даты создания статьи")
    public String getArticleDate() {
        return $(ARTICLE_DATE).innerText().trim();
    }

    @Step("На открывшейся странице проверить совпадение времени чтения статьи")
    public String getArticleReadingTime() {
        return $(ARTICLE_READING_TIME).innerText().trim();
    }
}