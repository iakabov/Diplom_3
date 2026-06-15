package expansion;

import config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver get() {
        String browserName = System.getenv().get("browser");
        if (browserName == null) {
            browserName = "firefox";
        }

        WebDriver driver;
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "yandex":
                driver = createYandexDriver();
                break;
            default: throw new RuntimeException("Browser " + browserName + " not exist");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_SECONDS_TIMEOUT));
        return driver;
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.firefox.driver", String.format("%s/%s", System.getenv("BROWSER_DRIVERS"),
                System.getenv("YANDEX_BROWSER_DRIVER_FILENAME")));
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        return new FirefoxDriver(options);
    }

}
