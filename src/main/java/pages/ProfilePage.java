package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; // ДОБАВИЛИ ИМПОРТ
import org.openqa.selenium.JavascriptExecutor; // ДОБАВИЛИ ИМПОРТ

public class ProfilePage {

    private final By buttonExit = By.xpath(".//button[text()='Выход']");
    private final By TitleProfile = By.xpath(".//a[text()='Профиль']");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // ИЗМЕНИЛИ: Нажатие кнопки «Выход» через JavaScript в обход оверлея
    public void clickButtonExit() {
        WebElement element = driver.findElement(buttonExit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isTitleProfile() {
        return driver.findElement(TitleProfile).isDisplayed();
    }
}