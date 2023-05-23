package pages.blogPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import steps.PageWithArticleParameters;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage implements PageWithArticleParameters {
    public static final By ARTICLE_CATEGORY = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt' or @class='sc-pGacB hqCMbN']//div//div//a");
    public static final By ARTICLE_NAME = By.xpath("//div//div//h1 | //div[@class='sc-hKgJUU jaxqmo']//p");
    public static final By ARTICLE_DATE = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt' or @class='sc-pGacB hqCMbN']//div//div//div");
    public static final By ARTICLE_READING_TIME = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt' or @class='sc-pGacB hqCMbN']//div//div//div//div");

    public String getArticleCategory(){
        return $(ARTICLE_CATEGORY).shouldBe(Condition.visible).innerText().trim();
    }
    public String getArticleName(){
        return $(ARTICLE_NAME).innerText().trim();
    }
    public String getArticleDate(){
        return $(ARTICLE_DATE).innerText().trim();
    }
    public String getArticleReadingTime(){
        return $(ARTICLE_READING_TIME).innerText().trim();
    }
}