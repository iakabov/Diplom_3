package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import io.qameta.allure.Step; // Импортируем аннотацию @Step

public class LoginPage {

    private final By inputEmail = By.xpath(".//input[@name='name']");
    private final By inputPassword = By.xpath(".//input[@name='Пароль']");
    private final By buttonEnter = By.xpath(".//button[text()='Войти']");
    private final By titleEnter = By.xpath(".//h2[text() = 'Вход']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка отображения заголовка входа")
    public boolean isTitleEnterDisplayed() {
        return driver.findElement(titleEnter).isDisplayed();
    }

    @Step("Вводим email: {email}")
    public void login(String email, String password) {
        setInputEmail(email);
        setInputPassword(password);
        clickButtonEnter();
    }

    @Step("Вводим email: {email}")
    private void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Вводим пароль")
    private void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Кликаем по кнопке 'Войти' через JavaScript")
    private void clickButtonEnter() {
        WebElement element = driver.findElement(buttonEnter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}