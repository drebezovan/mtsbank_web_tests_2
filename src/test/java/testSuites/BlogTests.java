package testSuites;

import org.junit.jupiter.api.Test;
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

public class BlogTests extends BaseTests{

    HomePage homePage = new HomePage();
    BlogPage blogPage = new BlogPage();
    CategoryPage depositsCategoryPage = new CategoryPage();
    ArticlePage articlePage = new ArticlePage();
    BlogInputData blogInputData;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    public void blogTest(int index) throws IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на постер "Блог"
        // на открывшейся странице (под названием "Блог") выбрать категорию, например "Вклады и счета"
        // сохранить (в переменные) параметры первой статьи: категорию, название, дату создания статьи и время чтения
        // нажать на первую статью
        // на открывшейся странице проверить совпадение параметров статьи

        blogInputData = mapper.readValue(fileForBlog, BlogInputData.class);
        homePage.openHomePage()
                .clickBlogPoster();
        blogPage.clickBlogCategory(blogInputData.getCategory().get(index));
        Map<String, String> articleParamsFromCategoryPage = depositsCategoryPage.getArticleParams();
        depositsCategoryPage.clickArticle();
        MapAssertions.assertMapEquals(articleParamsFromCategoryPage,articlePage.getArticleParams());
    }
    @Test
    public void blogMobileTest() {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на постер "Блог"
        // на открывшейся странице (под названием "Блог") нажать на "+3"
        // выбрать категорию, например "Вклады и счета"
        // сохранить (в переменные) параметры первой статьи: категорию, название, дату создания статьи и время чтения
        // нажать на первую статью
        // на открывшейся странице проверить совпадение параметров статьи
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickBlogPosterMobile("Блог");
        blogPage.clickBlogSelectCategory("+3")
                .clickBlogCategory(blogInputData.getCategory().get(0));
        Map<String, String> articleParamsFromDepositsCategoryPage = depositsCategoryPage.getArticleParams();
        System.out.println(articleParamsFromDepositsCategoryPage);
        depositsCategoryPage.clickArticle();
        System.out.println(articlePage.getArticleParams());
        MapAssertions.assertMapEquals(articleParamsFromDepositsCategoryPage,articlePage.getArticleParams());
    }
}