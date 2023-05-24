package pages.blogPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import steps.PageWithArticleParameters;

import static com.codeborne.selenide.Selenide.$;

public class CategoryPage implements PageWithArticleParameters {
    public static final By ARTICLE_CATEGORY = By.xpath
            ("//div[@class='sc-eCstlR SUwnL']//a | //div[@class='sc-iNqMzA jQvNAE']//a");
    public static final By ARTICLE_READING_TIME = By.xpath
            ("//div[@class='sc-hKgJUU jaxqmo']//div//div//div | //div[@class='sc-eJMPIT Werdk']//div");
    public static final By ARTICLE_NAME = By.xpath
            ("//div[@class='sc-hKgJUU jaxqmo']//p | //div[@class='sc-laRQdt eUTSjA']//p");
    public static final By ARTICLE_DATE = By.xpath
            ("//div[@class='sc-fubCzh hZosTh']//div | //div[@class='sc-higWrZ iLazrU']//div");
    public static final By ARTICLE = By.xpath
            ("//div[@class='sc-pGacB eHzbCx'] | //div[@class='sc-ehSDrC lhyqot']");

    @Step("Cохранить (в переменные) категорию")
    public String getArticleCategory() {
        return $(ARTICLE_CATEGORY).innerText().trim();
    }

    @Step("Cохранить (в переменные) время чтения")
    public String getArticleReadingTime() {
        return $(ARTICLE_READING_TIME).innerText().trim();
    }

    @Step("Cохранить (в переменные) название")
    public String getArticleName() {
        return $(ARTICLE_NAME).innerText().trim();
    }

    @Step("Cохранить (в переменные) дату создания статьи")
    public String getArticleDate() {
        return $(ARTICLE_DATE).innerText().trim();
    }

    @Step("Нажать на первую статью")
    public CategoryPage clickArticle() {
        $(ARTICLE).click();
        return this;
    }
}