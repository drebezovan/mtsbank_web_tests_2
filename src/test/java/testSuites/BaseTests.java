package testSuites;

import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        mapper = new ObjectMapper(new YAMLFactory());
        fileForCredit = new File("src/main/resources/yml/creditInputData.yml");
        fileForBusiness = new File("src/main/resources/yml/smallBusinessInputData.yml");
        fileForBlog = new File("src/main/resources/yml/blogInputData.yml");
        fileForPremium = new File("src/main/resources/yml/premiumInputData.yml");
        fileForTelegram = new File("src/main/resources/yml/telegramInputData.yml");
    }

    @AfterEach
    public void turnDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}