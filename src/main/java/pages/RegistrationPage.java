package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegistrationPage {

    // ИСПРАВИЛИ: Заменили длинные абсолютные пути на устойчивые короткие локаторы (в 2 шага)
    private final By inputName = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By inputPassword = By.xpath(".//input[@name='Пароль']");
    private final By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By buttonEnter = By.xpath(".//a[text()='Войти']");
    private final By messageIncorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Клик по ссылке «Войти» через JavaScript
    public void clickButtonEnter() {
        WebElement element = driver.findElement(buttonEnter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isMessageIncorrectPasswordDisplayed() {
        // Ждем до 5 секунд, пока сообщение «Некорректный пароль» физически появится
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(messageIncorrectPassword));

        return driver.findElement(messageIncorrectPassword).isDisplayed();
    }

    public void register(String name, String email, String password) {
        setInputName(name);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonRegistration();
    }

    private void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    private void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickButtonRegistration() {
        try {
            // Даем сайту полсекунды, чтобы шторка анимации полностью пропала
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Делаем честный клик Selenium, который сохранит фокус на полях и выведет ошибку пароля
        driver.findElement(buttonRegistration).click();
    }
}