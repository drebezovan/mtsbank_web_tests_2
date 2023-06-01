package testSuites;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.blogPages.ArticlePage;
import pages.blogPages.BlogPage;
import pages.blogPages.CategoryPage;
import pages.homePage.HomePage;
import steps.BlogInputData;
import steps.MapAssertions;

import java.io.IOException;
import java.util.Map;

@Epic("Web tests")
@Feature("MTS bank website")
@DisplayName("Тестовый набор сценариев для категории «Блог»")
@Link(name = "Ссылка на сайт", url = "https://www.mtsbank.ru/")
@Owner("Дребезова Наталья")
public class BlogTests extends BaseTests {

    HomePage homePage = new HomePage();
    BlogPage blogPage = new BlogPage();
    CategoryPage depositsCategoryPage = new CategoryPage();
    ArticlePage articlePage = new ArticlePage();
    BlogInputData blogInputData;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Feature("Десктопная версия сайта")
    @DisplayName("Проверка параметров категории «Блог»")
    @Description("Проверяем совпадение параметров (категорию, название, дату создания статьи и время чтения) " +
            "статьи на странице с разными статьями и на странице выбранной статьи")
    @Severity(SeverityLevel.NORMAL)
    public void blogTest(int index) throws IOException {
        blogInputData = mapper.readValue(fileForBlog, BlogInputData.class);
        homePage.openHomePage()
                .clickBlogPoster();
        blogPage.clickBlogCategory(blogInputData.getCategory().get(index));
        Map<String, String> articleParamsFromCategoryPage = depositsCategoryPage.getArticleParams();
        depositsCategoryPage.clickArticle();
        MapAssertions.assertMapEquals(articleParamsFromCategoryPage, articlePage.getArticleParams());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Feature("Мобильная версия сайта")
    @DisplayName("Проверка параметров категории «Блог»")
    @Description("Проверяем совпадение параметров (категорию, название, дату создания статьи и время чтения) " +
            "статьи на странице с разными статьями и на странице выбранной статьи")
    @Severity(SeverityLevel.NORMAL)
    public void blogMobileTest(int index) throws IOException {
        blogInputData = mapper.readValue(fileForBlog, BlogInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickBlogPosterMobile(blogInputData.getPosterName());
//        blogPage.clickBlogSelectCategory(blogInputData.getCategoryName())
        blogPage.clickBlogCategory(blogInputData.getCategory().get(index));
        Map<String, String> articleParamsFromDepositsCategoryPage = depositsCategoryPage.getArticleParams();
        depositsCategoryPage.clickArticle();
        MapAssertions.assertMapEquals(articleParamsFromDepositsCategoryPage, articlePage.getArticleParams());
    }
}