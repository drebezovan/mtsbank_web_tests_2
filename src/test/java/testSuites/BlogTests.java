package testSuites;

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
    @ValueSource(ints = { 1, 2, 3})
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
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3})
    public void blogMobileTest(int index) throws IOException {
        // открыть сайт https://www.mtsbank.ru/
        // нажать на постер "Блог"
        // на открывшейся странице (под названием "Блог") нажать на "+3"
        // выбрать категорию, например "Вклады и счета"
        // сохранить (в переменные) параметры первой статьи: категорию, название, дату создания статьи и время чтения
        // нажать на первую статью
        // на открывшейся странице проверить совпадение параметров статьи
        blogInputData = mapper.readValue(fileForBlog, BlogInputData.class);
        homePage.openHomePageMobile()
                .clickRegionField()
                .clickBlogPosterMobile(blogInputData.getPosterName());
        blogPage.clickBlogSelectCategory(blogInputData.getCategoryName())
                .clickBlogCategory(blogInputData.getCategory().get(index));
        Map<String, String> articleParamsFromDepositsCategoryPage = depositsCategoryPage.getArticleParams();
        depositsCategoryPage.clickArticle();
        MapAssertions.assertMapEquals(articleParamsFromDepositsCategoryPage,articlePage.getArticleParams());
    }
}