import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; // или ChromeDriver, смотря какой у вас базовый
import pages.MainPage;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(config.AppConfig.MAIN_URL);
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void clickOnSaucesSectionButton() {
        // Тест на соусы работал правильно, оставляем его
        mainPage.clickButtonSauce();
        assertTrue("Переход к соусам не произошёл", mainPage.isSauceSelected());
    }

    @Test
    public void clickOnIngredientsSectionButton() {
        // Тест на начинки работал правильно, оставляем его
        mainPage.clickButtonIngredient();
        assertTrue("Переход к начинкам не произошёл", mainPage.isIngredientSelected());
    }

    @Test
    public void clickOnBunsSectionButton() {
        // ИСПРАВИЛИ: Сначала принудительно кликаем на соусы, чтобы уйти с булок по умолчанию
        mainPage.clickButtonSauce();

        // Теперь кликаем обратно на булки — теперь сайт честно переключится!
        mainPage.clickButtonBun();
        assertTrue("Переход к булкам не произошёл", mainPage.isBunSelected());
    }
}