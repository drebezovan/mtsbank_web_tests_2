package testSuites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

public class BaseTests {
    ObjectMapper mapper;
    File fileForCredit;
    File fileForBusiness;
    File fileForBlog;
    File fileForPremium;
    File fileForTelegram;

    @BeforeEach
    public void setup() {
//        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        Configuration.remote = "http://localhost:4444/wd/hub";
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--remote-debugging-port=9222\"");
        mapper = new ObjectMapper(new YAMLFactory());
        fileForCredit = new File("src/main/resources/yml/creditInputData.yml");
        fileForBusiness = new File("src/main/resources/yml/smallBusinessInputData.yml");
        fileForBlog = new File("src/main/resources/yml/blogInputData.yml");
        fileForPremium = new File("src/main/resources/yml/premiumInputData.yml");
        fileForTelegram = new File("src/main/resources/yml/telegramInputData.yml");
    }

    @AfterEach
    public void turnDown() {
        Configuration.browser = "chrome";
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}