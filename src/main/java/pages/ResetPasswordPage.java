package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; // ДОБАВИЛИ ИМПОРТ
import org.openqa.selenium.JavascriptExecutor; // ДОБАВИЛИ ИМПОРТ

public class ResetPasswordPage {

    private final By buttonEnter = By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;
    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonEnter() {
        // Находим нашу ссылку «Войти»
        WebElement element = driver.findElement(buttonEnter);

        // Железобетонный клик через JS, который пробивает любые шторки в Firefox
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}