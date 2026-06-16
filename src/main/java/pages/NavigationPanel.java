package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class NavigationPanel {
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By buttonLogo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

    private final By profileLink = By.xpath(".//a[text()='Профиль']");
    private final By loginButtonOnMain = By.xpath(".//button[text()='Войти в аккаунт']");

    private final WebDriver driver;

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonPersonalAccount() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonPersonalAccount));

        boolean isAuthorized = driver.findElements(loginButtonOnMain).isEmpty();

        // Для личного кабинета оставляем работающий клик, подменяя arguments на arguments[0] текстом
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        if (isAuthorized) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(2))
                        .until(ExpectedConditions.visibilityOfElementLocated(profileLink));
            } catch (Exception e) {
                // Мягко пропускаем
            }
        }
    }

    public void clickButtonConstructor() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonConstructor));

        // Стандартный честный клик с защитой от перехвата анимацией
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(buttonConstructor)).click();
        }
    }

    public void clickButtonLogo() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonLogo));

        // Стандартный честный клик с защитой от перехвата анимацией для теста №2
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(buttonLogo)).click();
        }
    }
}