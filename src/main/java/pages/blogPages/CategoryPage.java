package pages.blogPages;

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

    public String getArticleCategory() {
        return $(ARTICLE_CATEGORY).innerText().trim();
    }

    public String getArticleReadingTime() {
        return $(ARTICLE_READING_TIME).innerText().trim();
    }

    public String getArticleName() {
        return $(ARTICLE_NAME).innerText().trim();
    }

    public String getArticleDate() {
        return $(ARTICLE_DATE).innerText().trim();
    }

    public CategoryPage clickArticle() {
        $(ARTICLE).click();
        return this;
    }

    public CategoryPage clickArticleCategory() {
        $(ARTICLE_CATEGORY).click();
        return this;
    }

}