package pandamoodtest;

import com.codeborne.selenide.Configuration;
import constants.DomainConstants;
import constants.WindowSizeConstants;
import model.WindowsSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import steps.AuthenticationSteps;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    static {
        System.setProperty("browser", "chrome");
    }
    AuthenticationSteps loginSteps = new AuthenticationSteps();

    @BeforeMethod
    public void setup() {
        Configuration.headless = false;
        Configuration.baseUrl = DomainConstants.BASE_URL;
        Configuration.browser = System.getProperty("browser");
        configureWindowSizeDependencies(WindowSizeConstants.MEDIUM_SIZE);
/*        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-popup");
        WebDriver driver = new ChromeDriver(chromeOptions);
        setWebDriver(driver);*/
    }

    public void configureWindowSizeDependencies(WindowsSize windowSize) {
        Configuration.browserSize = windowSize.getScreenSize();
        System.setProperty("HOME_PAGE_TITLE_CSS", windowSize.getElementClass());
        System.setProperty("HOME_POST_BUTTON_CSS", windowSize.getPostButton());
    }

}
