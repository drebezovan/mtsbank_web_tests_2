package pages.blogPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import steps.PageWithArticleParameters;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage implements PageWithArticleParameters {
    public static final By ARTICLE_CATEGORY = By.xpath
            ("//div[@class='sc-ehSDrC hIcRvt']//div//a | //div[@class='sc-pGacB hqCMbN']//div//a | " +
                    "//div[@class='sc-hKgJUU jaxqmo']//div//a |" +
                    "//div[@class='sc-hKgJUU jaxqmo']//div//a");
    public static final By ARTICLE_NAME = By.xpath("//div//div//h1 | //div[@class='sc-hKgJUU jaxqmo']//p");
    public static final By ARTICLE_DATE = By.xpath
            ("//div[@class='sc-fubCzh hZosTh']//div[@class='styled__SmartText-n9vm43-0 bOaTzw'] | " +
                    "//div[@class='sc-higWrZ iLazrU']//div[@class='sc-eJMPIT Werdk']//" +
                    "div[@class='styled__SmartText-n9vm43-0 grJLDx'] | //div[@class='sc-fubCzh hZosTh']//div");
    public static final By ARTICLE_READING_TIME = By.xpath
            ("//div[@class='sc-gKseQn gycvVa']//div[@class='styled__SmartText-n9vm43-0 bOaTzw '] " +
                    "| //div[@class='sc-gKseQn gycvVa']//div");

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
